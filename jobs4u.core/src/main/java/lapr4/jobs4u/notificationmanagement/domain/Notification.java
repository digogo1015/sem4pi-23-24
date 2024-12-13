package lapr4.jobs4u.notificationmanagement.domain;

import eapli.framework.domain.model.AggregateRoot;

import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.EmailAddress;
import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
public class Notification implements AggregateRoot<Long> {

    private static final long serialVersionUID = 1L;

    @Version
    private Long version;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime date;
    private String receiverEmail;
    private String notificationType;
    private String notificationState;
    private String message;
    private String senderEmail;

    public Notification(String receiverEmail, String notificationType, String notificationState, String message) {

        if (receiverEmail == null || notificationType == null || notificationState == null || message == null) {
            throw new IllegalArgumentException();
        }
        this.date = LocalDateTime.now();
        this.receiverEmail = receiverEmail;
        this.notificationType = notificationType;
        this.notificationState = notificationState;
        this.message = message;
        this.senderEmail = null;
    }

    public Notification(String  receiverEmail, String senderEmail, String notificationType, String notificationState, String message) {
        if (receiverEmail == null || senderEmail == null || notificationType == null || notificationState == null || message == null) {
            throw new IllegalArgumentException();
        }
        this.date = LocalDateTime.now();
        this.receiverEmail = receiverEmail;
        this.notificationType = notificationType;
        this.notificationState = notificationState;
        this.senderEmail = senderEmail;
        this.message = message;
    }


    protected Notification() {
    }

    @Override
    public boolean sameAs(final Object other) {
        return DomainEntities.areEqual(this, other);
    }


    @Override
    public Long identity() {
        return id;
    }

    public String receiverEmail() {
        return receiverEmail;
    }

    public String senderEmail() {
        return senderEmail;
    }

    public String notificationType() {
        return notificationType;
    }

    public String notificationState() {
        return notificationState;
    }

    public String message() {
        return message;
    }

    public LocalDateTime date() {
        return date;
    }

    public void changeNotificationState(String notificationState) {
        this.notificationState = notificationState;
    }


    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", date=" + date +
                ", receiverEmail=" + receiverEmail +
                ", notificationType='" + notificationType + '\'' +
                ", notificationState='" + notificationState + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

}
