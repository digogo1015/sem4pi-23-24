package lapr4.jobs4u.notificationmanagement.repositories;

import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.general.domain.model.EmailAddress;
import lapr4.jobs4u.notificationmanagement.domain.Notification;

import java.util.List;


public interface NotificationRepository
        extends DomainRepository<Long, Notification> {

    List<Notification> allNotViewedNotificationsByReceiver(String receiverEmail);

    List<Notification> allNotSentNotifications();

    List<Notification> allNotViewedNotificationsByReceiverApplication(String receiverEmail);

}
