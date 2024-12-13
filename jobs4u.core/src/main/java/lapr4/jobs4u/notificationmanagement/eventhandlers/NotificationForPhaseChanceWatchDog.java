package lapr4.jobs4u.notificationmanagement.eventhandlers;

import eapli.framework.domain.events.DomainEvent;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.pubsub.EventHandler;
import lapr4.jobs4u.notificationmanagement.event.PhaseChangeNotificationEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotificationForPhaseChanceWatchDog implements EventHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationForPhaseChanceWatchDog.class);

    @Override
    public void onEvent(final DomainEvent domainevent) {

        assert domainevent instanceof PhaseChangeNotificationEvent;

        final PhaseChangeNotificationEvent event = (PhaseChangeNotificationEvent) domainevent;

        final NotificationForPhaseChanceController controller = new NotificationForPhaseChanceController();
        try {
            controller.createNotification(event);
        } catch (final IntegrityViolationException e) {
            LOGGER.error("Unable to register new user on registered customer event", e);
        }
    }
}
