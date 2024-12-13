package lapr4.jobs4u.notificationmanagement.domain;

import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.EmailAddress;

public class NotificationBuilder implements DomainFactory<Notification> {

    private String receiverEmail;
    private String notificationType;
    private String notificationState;
    private String message;
    private String senderEmail;

    public NotificationBuilder withReceiverEmail(final String receiverEmail) {
        this.receiverEmail = receiverEmail;
        return this;
    }

    public NotificationBuilder withSenderEmail(final String senderEmail) {
        this.senderEmail = senderEmail;
        return this;
    }


    public NotificationBuilder withNotificationType(final String notificationType) {
        this.notificationType = notificationType;
        return this;
    }

    public NotificationBuilder withNotificationState(final String notificationState) {
        this.notificationState = notificationState;
        return this;
    }

    public NotificationBuilder withMessage(final String message) {
        this.message = message;
        return this;
    }

    @Override
    public Notification build() {
        return new Notification(this.receiverEmail, this.notificationType, this.notificationState, this.message);
    }

    public Notification buildWithSender() {
        return new Notification(this.receiverEmail, this.senderEmail, this.notificationType, this.notificationState, this.message);
    }

}
