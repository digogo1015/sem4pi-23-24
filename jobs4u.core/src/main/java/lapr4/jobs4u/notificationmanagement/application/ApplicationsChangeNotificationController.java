package lapr4.jobs4u.notificationmanagement.application;

import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.notificationmanagement.domain.Notification;
import lapr4.jobs4u.notificationmanagement.repositories.NotificationRepository;

import java.util.List;

public class ApplicationsChangeNotificationController {
    private final NotificationRepository notificationRepository = PersistenceContext.repositories().notifications();
    private final NotificationService notificationService = new NotificationService();

    public List<NotificationDTO> allNotViewedNotificationsByReceiver(String email) {

        List<Notification> notificationList = notificationRepository.allNotViewedNotificationsByReceiverApplication(email);


        return notificationService.allNotViewedNotificationsByReceiver(notificationList);
    }

}
