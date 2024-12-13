package lapr4.jobs4u.notificationmanagement.application;

import java.io.Serializable;

public class NotificationDTO implements Serializable {

    private final String message;
    private final String date;

    public NotificationDTO(String message, String date) {
        this.message = message;
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public String getDate() {
        return date;
    }

}
