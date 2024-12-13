package lapr4.jobs4u.persistence.impl.inmemory;

import lapr4.jobs4u.applicationmanagement.repository.ApplicationRepository;
import lapr4.jobs4u.candidatemanagement.repositories.CandidateRepository;
import lapr4.jobs4u.customermanagement.repositories.CustomerRepository;
import lapr4.jobs4u.infrastructure.bootstrapers.MasterUsersBootstrapper;
import lapr4.jobs4u.infrastructure.persistence.RepositoryFactory;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;
import lapr4.jobs4u.notificationmanagement.repositories.NotificationRepository;
import lapr4.jobs4u.pluginmanagement.repositories.PluginRepository;
import lapr4.jobs4u.rankmanagement.repositories.RankRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.inmemory.InMemoryUserRepository;

public class InMemoryRepositoryFactory implements RepositoryFactory {

    static {
        // only needed because of the in memory persistence
        new MasterUsersBootstrapper().execute();
    }

    @Override
    public UserRepository users(final TransactionalContext tx) {
        return new InMemoryUserRepository();
    }

    @Override
    public UserRepository users() {
        return users(null);
    }

    @Override
    public CustomerRepository customers(final TransactionalContext tx) {

        return new InMemoryCustomerRepository();
    }

    @Override
    public CustomerRepository customers() {
        return customers(null);
    }

    @Override
    public CandidateRepository candidates(TransactionalContext tx) {
        return new InMemoryCandidateRepository();
    }

    @Override
    public CandidateRepository candidates() {
        return candidates(null);
    }

    @Override
    public JobOpeningRepository jobOpenings(TransactionalContext tx) {
        return new InMemoryJobOpeningRepository();
    }

    @Override
    public JobOpeningRepository jobOpenings() {
        return jobOpenings(null);
    }

    @Override
    public ApplicationRepository applications(TransactionalContext tx) {
        return new InMemoryApplicationRepository();
    }

    @Override
    public ApplicationRepository applications() {
        return applications(null);
    }

    @Override
    public PluginRepository plugins(TransactionalContext tx) {
        return new InMemoryPluginRepository();
    }

    @Override
    public PluginRepository plugins() {
        return plugins(null);
    }

    @Override
    public RankRepository ranks(final TransactionalContext tx) {

        return new InMemoryRankRepository();
    }

    @Override
    public RankRepository ranks() {
        return ranks(null);
    }

    @Override
    public NotificationRepository notifications(final TransactionalContext tx) {

        return new InMemoryNotificationRepository();
    }

    @Override
    public NotificationRepository notifications() {
        return notifications(null);
    }


    @Override
    public TransactionalContext newTransactionalContext() {
        // in memory does not support transactions...
        return null;
    }

}
