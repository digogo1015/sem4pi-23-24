package lapr4.jobs4u.candidatemanagement.eventhandlers;

import eapli.framework.domain.events.DomainEvent;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.pubsub.EventHandler;
import lapr4.jobs4u.candidatemanagement.events.NewUserForCandidateEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewUserForCandidateWatchDog implements EventHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(NewUserForCandidateWatchDog.class);

    @Override
    public void onEvent(final DomainEvent domainevent) {

        assert domainevent instanceof NewUserForCandidateEvent;

        final NewUserForCandidateEvent event = (NewUserForCandidateEvent) domainevent;

        final AddCandidateOnUserCreationController controller = new AddCandidateOnUserCreationController();
        try {
            controller.addCandidate(event);
        } catch (final IntegrityViolationException e) {
            LOGGER.error("Unable to register new user on registered customer event", e);
        }
    }
}
