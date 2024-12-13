package lapr4.jobs4u.server.utils;

import lapr4.jobs4u.applicationmanagement.application.ApplicationDTO;
import lapr4.jobs4u.jobopeningmanagement.application.JobOpeningDTO;
import lapr4.jobs4u.notificationmanagement.application.NotificationDTO;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class TcpUtils {


    //Returns a String with data received from Server
    public static String readData(DataInputStream sIn) throws IOException {
        int dataLen = sIn.readUnsignedByte() + 256 * sIn.readUnsignedByte();
        byte[] data = new byte[dataLen];
        sIn.readFully(data);
        return new String(data, StandardCharsets.UTF_8);
    }

    public static byte[] readDataSerialize(DataInputStream sIn) throws IOException {
        int dataLen = sIn.readUnsignedByte() + 256 * sIn.readUnsignedByte();
        byte[] data = new byte[dataLen];
        sIn.readFully(data);
        return data;
    }

    //Writes data to Server
    public static void writeData(DataOutputStream sOut, String string) throws IOException {
        sOut.writeByte(string.length() % 256);
        sOut.writeByte(string.length() / 256);
        sOut.writeBytes(string);
    }

    public static void writeDataSerialize(DataOutputStream sOut, byte[] serial) throws IOException {
        sOut.writeByte(serial.length % 256);
        sOut.writeByte(serial.length / 256);
        sOut.write(serial);
    }


    public static boolean doLogin(DataInputStream sIn, DataOutputStream sOut, String username, String password, String role) throws IOException {

        sOut.write(1); //version
        sOut.write(4); //AUTH code

        writeData(sOut, username); //typed username
        writeData(sOut, password); //types passWord
        writeData(sOut, role); //supposed role of user

        return receiveResponse(sIn);

    }

    public static boolean receiveResponse(DataInputStream sIn) throws IOException {
        int version = sIn.readUnsignedByte();
        int code = sIn.readUnsignedByte();

        switch (code) {
            case 2:
                System.out.println("Request Successful");
                break;

            case 3:
                int data1_len = sIn.readUnsignedByte() + 256 * sIn.readUnsignedByte();
                byte[] data1 = new byte[data1_len];
                sIn.readFully(data1);
                String errorMsg = new String(data1, StandardCharsets.UTF_8);
                System.out.println("Error: " + errorMsg + "| Version : " + version);

                return false;

            case 7:

                int numberOfJobOpenings = Integer.parseInt(TcpUtils.readData(sIn));
                if (numberOfJobOpenings <= 0) {
                    System.out.println("\nNo Job Openings");
                } else {

                    System.out.printf("\n#  %-20s%-20s%-20s%-20s\n", "Job Reference", "Job Title", "Active Since", "Number of Vacancies");

                    byte[] serial = readDataSerialize(sIn);

                    List<JobOpeningDTO> list = TcpUtils.deserializeList(serial);

                    for (JobOpeningDTO jobOpening : list) {
                        System.out.printf("#  %-20s%-20s%-20s%-20s\n", jobOpening.reference(), jobOpening.title(), jobOpening.date(), jobOpening.vacancies());
                    }
                }
                receiveResponse(sIn);
                break;

            case 5:
                int numberOfApplications = Integer.parseInt(TcpUtils.readData(sIn));
                if (numberOfApplications <= 0) {
                    System.out.println("\nNo Applications");
                } else {
                    System.out.println("\n+= APPLICATIONS ==========================================================+");

                    byte[] serial = readDataSerialize(sIn);
                    List<ApplicationDTO> list = TcpUtils.deserializeList(serial);

                    for (ApplicationDTO application : list) {
                        System.out.println("Application ID: " + application.id());
                        System.out.println("Job Opening: " + application.jobOpeningTitle());
                        System.out.println("Application Date: " + application.date());
                        System.out.println("Application State: " + application.state() + "\n");

                        System.out.println("Number of Applicants: " + application.numberOfApplicants() + "\n");
                    }
                }
                receiveResponse(sIn);
                break;

            case 6: //same as 8

            case 8:

                int numberOfCustomerNotifications = Integer.parseInt(TcpUtils.readData(sIn));
                if (numberOfCustomerNotifications <= 0) {
                    System.out.println("\nNo New Notifications");
                } else {
                    System.out.println("\n+= NEW NOTIFICATIONS ==========================================================+");

                    byte[] serial = readDataSerialize(sIn);

                    List<NotificationDTO> list = TcpUtils.deserializeList(serial);

                    for (NotificationDTO notification : list) {
                        System.out.println("Received on: " + notification.getDate());
                        System.out.println("Content: " + notification.getMessage() + "\n");

                    }
                }
                receiveResponse(sIn);
                break;

        }

        return true;
    }

    public static <E> byte[] serialize(E serialize) {

        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {

            objectOutputStream.writeObject(serialize);
            return byteArrayOutputStream.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <E> byte[] serializeIterable(Iterable<E> serialize) {

        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {

            objectOutputStream.writeObject(serialize);
            return byteArrayOutputStream.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static <E> E deserialize(byte[] data) {
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
             ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {

            return (E) objectInputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }


    private static <T> List<T> deserializeList(byte[] data) {
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
             ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {

            return (List<T>) objectInputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
