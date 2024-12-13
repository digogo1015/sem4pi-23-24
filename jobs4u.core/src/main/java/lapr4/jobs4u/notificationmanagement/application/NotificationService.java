package lapr4.jobs4u.notificationmanagement.application;

import eapli.framework.domain.events.DomainEvent;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.pubsub.EventPublisher;
import eapli.framework.infrastructure.pubsub.impl.inprocess.service.InProcessPubSub;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.notificationmanagement.domain.Notification;
import lapr4.jobs4u.notificationmanagement.domain.NotificationState;
import lapr4.jobs4u.notificationmanagement.domain.NotificationType;
import lapr4.jobs4u.notificationmanagement.event.ApplicationChangeNotificationEvent;
import lapr4.jobs4u.notificationmanagement.event.PhaseChangeNotificationEvent;
import lapr4.jobs4u.notificationmanagement.repositories.NotificationRepository;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class NotificationService {

    private final EventPublisher dispatcher = InProcessPubSub.publisher();
    private final NotificationRepository notificationRepository = PersistenceContext.repositories().notifications();
    private static final String SMTP_SERVER = "frodo.dei.isep.ipp.pt";
    private static final int SMTP_PORT = 25;

    public void publishPhaseChangeNotification(final String phase, final String jobReference, final EmailAddress receiver) {

        String message = "Your job Opening with reference \"" + jobReference + "\" has changed Phased!\nCurrent Phase: " + phase;
        // notify interested parties
        final DomainEvent event = new PhaseChangeNotificationEvent(NotificationState.NOT_VIEWED, NotificationType.PHASE_CHANGE, message, receiver);
        dispatcher.publish(event);
    }

    public void publishApplicationChangeNotification(final String state, final String applicationID, final EmailAddress receiver) {

        String message = "Your Application with ID \"" + applicationID + "\" has changed State!\nCurrent State: " + state;
        // notify interested parties
        final DomainEvent event = new ApplicationChangeNotificationEvent(NotificationState.NOT_VIEWED, NotificationType.APPLICATION_CHANGE, message, receiver);
        dispatcher.publish(event);
    }

    public void notificationViewed(Notification notification) {
        notification.changeNotificationState(NotificationState.VIEWED);
        notificationRepository.save(notification);
    }

    public void sendEmail(EmailDTO emailDTO) {
        String subject = "Subject: Notification of Verification Outcome";
        String body = buildEmailBody(emailDTO);

        try (Socket socket = new Socket(SMTP_SERVER, SMTP_PORT);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8))) {

            // Read server's initial response
            readResponse(reader);

            sendCommand(writer, reader, "HELO " + SMTP_SERVER);
            sendCommand(writer, reader, "MAIL FROM:<" + emailDTO.fromEmail() + ">");
            sendCommand(writer, reader, "RCPT TO:<" + emailDTO.toEmail() + ">");
            sendCommand(writer, reader, "DATA");

            sendCommand(writer, "From: \"" + emailDTO.fromName() + "\" <" + emailDTO.fromEmail() + ">");
            sendCommand(writer, "To: <" + emailDTO.toEmail() + ">");
            sendCommand(writer, subject);
            sendCommand(writer, "");
            sendCommand(writer, body);
            sendCommand(writer, ".");

            readResponse(reader); // Read final response for DATA

            sendCommand(writer, reader, "QUIT");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String buildEmailBody(EmailDTO emailDTO) {
        return "Dear " + emailDTO.toName() + ",\n\n" +
                "Congratulations, you have met the qualifications for 'Trolha' and you have been selected for one of our vacancies\n\n" +
                "Best regards,\n" +
                emailDTO.yourName() + "\n" +
                "Customer Manager\n" +
                emailDTO.companyName();
    }

    private static void sendCommand(BufferedWriter writer, BufferedReader reader, String command) throws IOException {
        writer.write(command + "\r\n");
        writer.flush();
        readResponse(reader);
    }

    private static void sendCommand(BufferedWriter writer, String command) throws IOException {
        writer.write(command + "\r\n");
        writer.flush();
    }

    private static void readResponse(BufferedReader reader) throws IOException {
        String response;
        while ((response = reader.readLine()) != null) {
            if (response.charAt(3) != '-') {
                break;
            }
        }
        if (response != null && response.startsWith("5")) {
            throw new IOException("SMTP Error: " + response);
        }
    }

    public List<NotificationDTO> allNotViewedNotificationsByReceiver(List<Notification> notifications) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        final List<NotificationDTO> ret = new ArrayList<>();

        for (Notification notification : notifications) {
            notificationViewed(notification);
            ret.add(new NotificationDTO(notification.message(), notification.date().format(formatter)));
        }

        return ret;
    }

    public void sendEmailForCustomer(EmailDTO emailDTO) {
        String subject = "Subject: Notification of Verification Outcome";
        String body = buildEmailBodyForCustomer(emailDTO);

        try (Socket socket = new Socket(SMTP_SERVER, SMTP_PORT);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8))) {

            // Read server's initial response
            readResponse(reader);

            sendCommand(writer, reader, "HELO " + SMTP_SERVER);
            sendCommand(writer, reader, "MAIL FROM:<" + emailDTO.fromEmail() + ">");
            sendCommand(writer, reader, "RCPT TO:<" + emailDTO.toEmail() + ">");
            sendCommand(writer, reader, "DATA");

            sendCommand(writer, "From: \"" + emailDTO.fromName() + "\" <" + emailDTO.fromEmail() + ">");
            sendCommand(writer, "To: <" + emailDTO.toEmail() + ">");
            sendCommand(writer, subject);
            sendCommand(writer, "");
            sendCommand(writer, body);
            sendCommand(writer, ".");

            readResponse(reader); // Read final response for DATA

            sendCommand(writer, reader, "QUIT");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String buildEmailBodyForCustomer(EmailDTO emailDTO) {

        List<Candidate> candidateList = emailDTO.candidateList();
        String candidates = "";

        for (Candidate candidate : candidateList)
            candidates += candidate.fullName() + "\n";

        return "Dear " + emailDTO.toName() + ",\n\n" +
                "Here is the list of Candidates that have been selected for you Job Opening:\n\n"
                + candidates + "\n" +
                "Best regards,\n" +
                emailDTO.yourName() + "\n" +
                "Customer Manager\n" +
                emailDTO.fromEmail();
    }
}
