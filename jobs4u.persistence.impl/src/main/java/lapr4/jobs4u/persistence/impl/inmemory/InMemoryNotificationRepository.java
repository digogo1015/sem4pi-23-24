package lapr4.jobs4u.persistence.impl.inmemory;

import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import lapr4.jobs4u.notificationmanagement.domain.Notification;
import lapr4.jobs4u.notificationmanagement.repositories.NotificationRepository;

import java.util.List;

public class InMemoryNotificationRepository
        extends InMemoryDomainRepository<Notification, Long>
        implements NotificationRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public List<Notification> allNotViewedNotificationsByReceiver(String receiverEmail) {
        return (List<Notification>) match(e -> e.receiverEmail() == receiverEmail && e.notificationState().equals("NOT_VIEWED") && e.notificationType().equals("PHASE_CHANGE"));
    }

    @Override
    public List<Notification> allNotSentNotifications() {
        return (List<Notification>) match(e -> e.notificationState().equals("NOT_SENT") && e.notificationType().equals("APPLICATION_RESULTS"));
    }

    @Override
    public List<Notification> allNotViewedNotificationsByReceiverApplication(String receiverEmail) {
        return (List<Notification>) match(e -> e.receiverEmail() == receiverEmail && e.notificationState().equals("NOT_VIEWED") && e.notificationType().equals("APPLICATION_CHANGE"));
    }

}
