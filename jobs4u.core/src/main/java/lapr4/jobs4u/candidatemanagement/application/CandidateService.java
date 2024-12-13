package lapr4.jobs4u.candidatemanagement.application;

import eapli.framework.domain.events.DomainEvent;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.pubsub.EventPublisher;
import eapli.framework.infrastructure.pubsub.impl.inprocess.service.InProcessPubSub;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.candidatemanagement.events.NewUserForCandidateEvent;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.usermanagement.domain.UserBuilderHelper;
import lapr4.jobs4u.usermanagement.domain.UserRoles;

import java.util.*;


public class CandidateService {

    private final UserRepository userRepository = PersistenceContext.repositories().users();
    private final EventPublisher dispatcher = InProcessPubSub.publisher();


    public List<Candidate> sortUserAlphabetically(List<Candidate> candidates) {
        candidates.sort(new Comparator<Candidate>() {
            @Override
            public int compare(Candidate c1, Candidate c2) {
                return c1.firstName().toLowerCase().compareTo(c2.firstName().toLowerCase());
            }
        });

        return candidates;
    }

    public void registerCandidate(final String firstName, final String lastName, final String phoneNumber,
                                  final String emailAddress, final String username, final String password) {

        final SystemUserBuilder userBuilder = UserBuilderHelper.builder();
        userBuilder.withUsername(username).withPassword(password).withName(firstName, lastName)
                .withEmail(emailAddress).withRoles(UserRoles.CANDIDATE);

        final SystemUser newUser = userRepository.save(userBuilder.build());

        // notify interested parties
        final DomainEvent event = new NewUserForCandidateEvent(newUser, firstName, lastName, phoneNumber, emailAddress);
        dispatcher.publish(event);
    }
}
