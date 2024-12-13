package lapr4.jobs4u.persistence.impl.jpa;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import lapr4.jobs4u.Application;
import lapr4.jobs4u.notificationmanagement.domain.Notification;
import lapr4.jobs4u.notificationmanagement.repositories.NotificationRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class JpaNotificationRepository
        extends JpaAutoTxRepository<Notification, Long, Long>
        implements NotificationRepository {

    public JpaNotificationRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaNotificationRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "id");
    }

    @Override
    public List<Notification> allNotViewedNotificationsByReceiver(String receiverEmail) {
        final Map<String, Object> params = new HashMap<>();
        params.put("email", receiverEmail);
        params.put("state", "NOT_VIEWED");
        params.put("type", "PHASE_CHANGE");
        return match("e.receiverEmail=: email AND e.notificationState=: state AND e.notificationType=: type", params);
    }

    @Override
    public List<Notification> allNotSentNotifications() {
        final Map<String, Object> params = new HashMap<>();
        params.put("state", "NOT_SENT");
        params.put("type", "APPLICATION_RESULTS");
        return match("e.notificationState=: state AND e.notificationType=: type", params);
    }


    @Override
    public List<Notification> allNotViewedNotificationsByReceiverApplication(String receiverEmail) {
        final Map<String, Object> params = new HashMap<>();
        params.put("email", receiverEmail);
        params.put("state", "NOT_VIEWED");
        params.put("type", "APPLICATION_CHANGE");
        return match("e.receiverEmail=: email AND e.notificationState=: state AND e.notificationType=: type", params);
    }

}
