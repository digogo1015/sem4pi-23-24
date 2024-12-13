package lapr4.jobs4u.server;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.Username;
import lapr4.jobs4u.applicationmanagement.application.ApplicationDTO;
import lapr4.jobs4u.applicationmanagement.application.ListCandidateApplicationsController;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.candidatemanagement.repositories.CandidateRepository;
import lapr4.jobs4u.infrastructure.authz.AuthenticationCredentialHandler;
import lapr4.jobs4u.infrastructure.authz.CredentialHandler;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.jobopeningmanagement.application.JobOpeningDTO;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.notificationmanagement.application.*;
import lapr4.jobs4u.jobopeningmanagement.application.ListCustomerJobOpeningsController;
import lapr4.jobs4u.server.utils.TcpUtils;
import lapr4.jobs4u.usermanagement.domain.UserPasswordPolicy;
import lapr4.jobs4u.usermanagement.domain.UserRoles;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

class TcpSrv {
    static ServerSocket sock;
    private static final PublishResultsController publishResultsController = new PublishResultsController();


    public static void main(String[] args) throws Exception {
        Socket cliSock;
        AuthzRegistry.configure(PersistenceContext.repositories().users(), new UserPasswordPolicy(), new PlainTextEncoder());
        try {
            sock = new ServerSocket(1234);
        } catch (IOException ex) {
            System.out.println("Failed to open server socket");
            System.exit(1);
        }

        new Thread(() -> {
            System.out.println("Email Sender Thread Started");
            while (true) {
                try {
                    List<Application> applicationsToNotify = publishResultsController.findAcceptedNonNotifiedApplications();
                    for (Application application : applicationsToNotify) {
                        publishResultsController.sendEmail(application);
                        publishResultsController.defineEmailResult(application);
                    }

                    JobOpening jobOpening = applicationsToNotify.get(0).jobOpening();
                    if (!jobOpening.emailResult()) {
                        publishResultsController.sendEmailForCustomer(jobOpening.customer(), applicationsToNotify);
                        publishResultsController.defineCustomerNotification(jobOpening);
                    }

                } catch (Exception e) {
                    continue;
                }

                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        CandidateRepository candidateRepository = PersistenceContext.repositories().candidates();


        while (true) {
            cliSock = sock.accept();
            new Thread(new TcpSrvThread(cliSock)).start();
        }
    }
}

class TcpSrvThread implements Runnable {
    private final Socket s;
    private final byte COMMTEST = 0;
    private final byte DISCONN = 1;
    private final byte ACK = 2;
    private final byte ERR = 3;
    private final byte AUTH = 4;
    private final byte US_3000 = 5;
    private final byte US_3001 = 6;
    private final byte US_3002 = 7;
    private final byte US_3003 = 8;

    private final CandidateRepository candidateRepository;

    public TcpSrvThread(Socket cli_s) {
        s = cli_s;
        candidateRepository = PersistenceContext.repositories().candidates();
    }

    public void run() {
        InetAddress clientIP;
        clientIP = s.getInetAddress();
        System.out.println("New client connection from " + clientIP.getHostAddress() + ", port number " + s.getPort());
        try {

            DataOutputStream sOut = new DataOutputStream(s.getOutputStream());
            DataInputStream sIn = new DataInputStream(s.getInputStream());

            while (true) {
                int version = sIn.readUnsignedByte();
                int code = sIn.readUnsignedByte();

                switch (code) {
                    case COMMTEST:
                        ack(version, sOut);
                        break;

                    case DISCONN:
                        System.out.println("Client " + clientIP.getHostAddress() +
                                ", port number: " + s.getPort() + " disconnected");
                        ack(version, sOut);
                        s.close();
                        return;

                    case ACK:
                        ack(version, sOut);
                        break;

                    case ERR:
                        err(version, sOut, "ERROR");
                        break;
                    case AUTH:
                        authenticate(version, sIn, sOut);
                        break;
                    case US_3000:
                        listApplicationsByCandidate(version, sIn, sOut);
                        break;
                    case US_3001:
                        showApplicationsChangeNotification(version, sIn, sOut);
                        break;

                    case US_3002:
                        listCustomerJobOpenings(version, sIn, sOut);
                        break;

                    case US_3003:
                        showPhaseChangeNotifications(version, sIn, sOut);
                        break;

                }
            }
        } catch (IOException ex) {
            System.out.println("IOException");
        }
    }

    private String readData(DataInputStream sIn) throws IOException {
        return TcpUtils.readData(sIn);
    }

    private void writeData(DataOutputStream sOut, String string) throws IOException {
        TcpUtils.writeData(sOut, string);
    }

    private void ack(int version, DataOutputStream sOut) throws IOException {
        System.out.println("ACK sent to Client!");
        sOut.write(version);
        sOut.write(2);
    }

    private void err(int version, DataOutputStream sOut, String errorMessage) throws IOException {
        System.out.println("ERR sent to Client!");
        sOut.write(version);
        sOut.write(3);
        writeData(sOut, errorMessage);
    }

    private void authenticate(int version, DataInputStream sIn, DataOutputStream sOut) throws IOException {
        try {
            Role onlyWithThis = UserRoles.CANDIDATE;
            CredentialHandler credentialHandler = new AuthenticationCredentialHandler();
            String username = readData(sIn);
            String password = readData(sIn);
            String role = readData(sIn);

            if (role.equals("customer"))
                onlyWithThis = UserRoles.CUSTOMER;

            if (credentialHandler.authenticated(username, password, onlyWithThis)) {
                System.out.println("User " + username + "authenticated successfully");
                ack(version, sOut);
                return;
            }
        } catch (Exception ignored) {
        }
        err(version, sOut, "Login Request was not Successful");
    }

    private void showApplicationsChangeNotification(int version, DataInputStream sIn, DataOutputStream sOut) throws IOException {
        ApplicationsChangeNotificationController controller = new ApplicationsChangeNotificationController();
        String username = readData(sIn);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        try {
            List<NotificationDTO> notViewedNotifications = controller.allNotViewedNotificationsByReceiver(username);

            sOut.writeByte(version);
            sOut.writeByte(US_3001);
            writeData(sOut, String.valueOf(notViewedNotifications.size()));

            if (!notViewedNotifications.isEmpty()) {

                byte[] serial = TcpUtils.serializeIterable(notViewedNotifications);
                TcpUtils.writeDataSerialize(sOut, serial);

            }
            System.out.println("Notifications sent to Client");
            ack(version, sOut);
        } catch (Exception exception) {
            err(version, sOut, exception.getMessage());
        }
    }

    private void listApplicationsByCandidate(int version, DataInputStream sIn, DataOutputStream sOut) throws IOException {
        ListCandidateApplicationsController controller = new ListCandidateApplicationsController();
        String username = readData(sIn);

        try {
            // Candidato pelo Username
            Candidate candidate = CandidateByUsername(username);
            if (candidate == null) {
                throw new IllegalArgumentException("Candidate not found for username: " + username);
            }

            List<ApplicationDTO> applications = controller.listApplicationsByCandidate(candidate);

            sOut.writeByte(version);
            sOut.writeByte(US_3000);
            writeData(sOut, String.valueOf(applications.size()));

            if (!applications.isEmpty()) {
                byte[] serial = TcpUtils.serializeIterable(applications);
                TcpUtils.writeDataSerialize(sOut, serial);
            }

            System.out.println("Applications sent to Client");
            ack(version, sOut);
        } catch (Exception exception) {
            err(version, sOut, exception.getMessage());
        }
    }

    // É usado para pegar o nome do Candidato que candidatou-se
    private Candidate CandidateByUsername(String username) {
        Username user = Username.valueOf(username);
        Optional<Candidate> candidate = candidateRepository.findByUsername(user);
        return candidate.orElse(null);
    }

    private void showPhaseChangeNotifications(int version, DataInputStream sIn, DataOutputStream sOut) throws IOException {
        PhaseChangeNotificationsController controller = new PhaseChangeNotificationsController();
        String username = readData(sIn);

        try {
            List<NotificationDTO> notViewedNotifications = controller.allNotViewedNotificationsByReceiver(username);

            sOut.writeByte(version);
            sOut.writeByte(8);
            writeData(sOut, String.valueOf(notViewedNotifications.size()));

            if (!notViewedNotifications.isEmpty()) {

                byte[] serial = TcpUtils.serializeIterable(notViewedNotifications);
                TcpUtils.writeDataSerialize(sOut, serial);

            }
            System.out.println("Notifications sent to Client");
            ack(version, sOut);
        } catch (Exception exception) {
            err(version, sOut, exception.getMessage());
        }
    }

    private void listCustomerJobOpenings(int version, DataInputStream sIn, DataOutputStream sOut) throws IOException {
        ListCustomerJobOpeningsController controller = new ListCustomerJobOpeningsController();
        String username = readData(sIn);

        try {
            List<JobOpeningDTO> customerJobOpenings = controller.allCustomerJobOpeningsWithRecruitmentProcess(username);

            sOut.writeByte(version);
            sOut.writeByte(7);
            writeData(sOut, String.valueOf(customerJobOpenings.size()));

            if (!customerJobOpenings.isEmpty()) {

                byte[] serial = TcpUtils.serializeIterable(customerJobOpenings);
                TcpUtils.writeDataSerialize(sOut, serial);
            }
            System.out.println("JobOpenings sent to Client");
            ack(version, sOut);
        } catch (Exception exception) {
            err(version, sOut, exception.getMessage());
        }
    }
}

