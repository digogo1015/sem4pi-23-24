/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package lapr4.jobs4u.candidatemanagement.eventhandlers;

import eapli.framework.application.UseCaseController;
import eapli.framework.domain.events.DomainEvent;
import eapli.framework.functional.Functions;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.pubsub.EventPublisher;
import eapli.framework.infrastructure.pubsub.impl.inprocess.service.InProcessPubSub;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.candidatemanagement.domain.CandidateBuilder;
import lapr4.jobs4u.candidatemanagement.events.ErrorCreatingCandidateEvent;
import lapr4.jobs4u.candidatemanagement.events.NewUserForCandidateEvent;
import lapr4.jobs4u.candidatemanagement.repositories.CandidateRepository;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;

import java.util.Optional;


@UseCaseController
public class AddCandidateOnUserCreationController {
    private final UserRepository repo = PersistenceContext.repositories().users();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final EventPublisher dispatcher = InProcessPubSub.publisher();
    private final CandidateRepository candidateRepository = PersistenceContext
            .repositories().candidates();

    public void addCandidate(final NewUserForCandidateEvent event) {
        if (findUser(event)) {
            try {
                final CandidateBuilder candidateBuilder = new CandidateBuilder();

                final Candidate newCandidate = candidateBuilder.withCandidateFirstName(event.firstName()).withCandidateLastName
                        (event.lastName()).withSystemUser(event.user()).withPhoneNumber(event.PhoneNumber()).withEmailAddress
                        (event.emailAddress()).build();
                candidateRepository.save(newCandidate);

            } catch (Exception ex) {
                final DomainEvent error = new ErrorCreatingCandidateEvent(event.user());
                dispatcher.publish(error);
            }
        }
    }

    @SuppressWarnings("squid:S1488")
    private boolean findUser(final NewUserForCandidateEvent event) {
        // since we are using events, the actual user may not yet be
        // created, so lets give it a time and wait
        final Optional<SystemUser> newUser = Functions.retry(() ->
                repo.ofIdentity(event.user().username()), 1000, 3);
        return (newUser.isPresent());
    }
}
