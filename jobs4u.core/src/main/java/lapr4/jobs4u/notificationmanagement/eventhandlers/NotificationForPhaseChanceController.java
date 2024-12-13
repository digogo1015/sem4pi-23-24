package lapr4.jobs4u.notificationmanagement.eventhandlers;

import eapli.framework.application.UseCaseController;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.notificationmanagement.domain.Notification;
import lapr4.jobs4u.notificationmanagement.domain.NotificationBuilder;
import lapr4.jobs4u.notificationmanagement.event.PhaseChangeNotificationEvent;
import lapr4.jobs4u.notificationmanagement.repositories.NotificationRepository;

@UseCaseController
        /* package */ class NotificationForPhaseChanceController {
    private final NotificationRepository notificationRepository = PersistenceContext
            .repositories().notifications();

    public void createNotification(final PhaseChangeNotificationEvent event) {

        final NotificationBuilder notificationBuilder = new NotificationBuilder();

        final Notification notification = notificationBuilder.withNotificationState(event.notificationState()).
                withNotificationType(event.notificationType()).withMessage(event.message()).
                withReceiverEmail(event.receiver().toString()).build();

        notificationRepository.save(notification);

    }

}
