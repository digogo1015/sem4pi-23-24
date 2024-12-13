package lapr4.jobs4u.app.customer.console.presentation.customerClient;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.jobs4u.server.utils.TcpUtils;
import lombok.SneakyThrows;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpCustomerUI extends AbstractUI {
    static InetAddress serverIP;
    static Socket sock;
    static String server = "127.0.0.1";
    //static String server = "10.8.0.80";

    static String username;

    //static String s = "";

    @SneakyThrows
    @Override
    protected boolean doShow() {
        try {
            serverIP = InetAddress.getByName(server);
        } catch (UnknownHostException ex) {
            System.out.println("Invalid server specified: " + server);
            System.exit(1);
        }
        try {
            sock = new Socket(serverIP, 1234);
        } catch (IOException ex) {
            System.out.println("Failed to establish TCP connection");
            System.exit(1);
        }
        DataOutputStream sOut = new DataOutputStream(sock.getOutputStream());
        DataInputStream sIn = new DataInputStream(sock.getInputStream());

        username = Console.readNonEmptyLine("Email:", "Please provide a email");

        final String password = Console.readLine("Password:");

        boolean login = TcpUtils.doLogin(sIn, sOut, username, password, "customer"); //DO AUTH

        if (login) {
            userMenu(sIn, sOut); //Show User Menu
        }

        sock.close(); //close socket connection

        return false;
    }

    private static void userMenu(DataInputStream sIn, DataOutputStream sOut) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input;
        int option = 0;


        do {
            System.out.println("\n\n+= Customer App [ @" + username + " ] ====================================+\n");
            System.out.println("1. End Session (Disconnect)");
            System.out.println("2. List My Job Openings");
            System.out.println("3. View Phase Change Notifications");

            System.out.println("\nPlease choose an option");

            try {

                input = in.readLine();

                option = Integer.parseInt(input);

                while (option > 3 || option < 1) {
                    System.out.println("Invalid option!\n");
                    System.out.println("Select an option: ");
                    input = in.readLine();
                    option = Byte.parseByte(input);
                }

                switch (option) {
                    case 1:
                        sOut.write(1);
                        sOut.write(1);
                        break;

                    case 2:
                        sOut.write(1);
                        sOut.write(7);
                        TcpUtils.writeData(sOut, username);
                        break;

                    case 3:
                        sOut.write(1);
                        sOut.write(8);
                        TcpUtils.writeData(sOut, username);
                        break;

                }

                TcpUtils.receiveResponse(sIn);

            } catch (NumberFormatException ex) {
                System.out.println("Invalid Option");
            }

        } while (option != 1);
    }

    @Override
    public String headline() {
        return null;
    }
}