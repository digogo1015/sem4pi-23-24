package lapr4.jobs4u.candidatemanagement.repositories;

import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Username;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;

import java.util.Optional;

public interface CandidateRepository
        extends DomainRepository<EmailAddress, Candidate> {

    Optional<Candidate> findByUsername(Username name);

    Candidate findByEmailAddress(EmailAddress emailAddress);

    Iterable<Candidate> findAllActive();

    Iterable<Candidate> findAllDeactivated();
}