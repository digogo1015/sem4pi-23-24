package lapr4.jobs4u.notificationmanagement.event;

import eapli.framework.domain.events.DomainEventBase;
import eapli.framework.general.domain.model.EmailAddress;

public class PhaseChangeNotificationEvent extends DomainEventBase {

    private static final long serialVersionUID = 1L;
    private final String notificationState;
    private final String notificationType;
    private final String message;
    private final EmailAddress receiver;


    public PhaseChangeNotificationEvent(final String notificationState, final String notificationType,
                                        final String message, final EmailAddress receiver) {

        this.notificationState = notificationState;
        this.notificationType = notificationType;
        this.message = message;
        this.receiver = receiver;
    }

    public String notificationState() {
        return notificationState;
    }

    public String notificationType() {
        return notificationType;
    }

    public String message() {
        return message;
    }

    public EmailAddress receiver() {
        return receiver;
    }


    @Override
    public String toString() {
        return "NewPhaseChangeNotification";
    }
}
