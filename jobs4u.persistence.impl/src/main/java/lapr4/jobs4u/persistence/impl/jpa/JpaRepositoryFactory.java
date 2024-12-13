package lapr4.jobs4u.persistence.impl.jpa;

import lapr4.jobs4u.Application;
import lapr4.jobs4u.infrastructure.persistence.RepositoryFactory;
import lapr4.jobs4u.notificationmanagement.repositories.NotificationRepository;
import lapr4.jobs4u.rankmanagement.repositories.RankRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.jpa.JpaAutoTxUserRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaRepositoryFactory implements RepositoryFactory {

    @Override
    public UserRepository users(final TransactionalContext autoTx) {
        return new JpaAutoTxUserRepository(autoTx);
    }

    @Override
    public UserRepository users() {
        return new JpaAutoTxUserRepository(Application.settings().getPersistenceUnitName(),
                Application.settings().getExtendedPersistenceProperties());
    }

    @Override
    public JpaCustomerRepository customers(final TransactionalContext autoTx) {
        return new JpaCustomerRepository(autoTx);
    }

    @Override
    public JpaCustomerRepository customers() {
        return new JpaCustomerRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public JpaCandidateRepository candidates(final TransactionalContext autoTx) {
        return new JpaCandidateRepository(autoTx);
    }

    @Override
    public JpaCandidateRepository candidates() {
        return new JpaCandidateRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public JpaJobOpeningRepository jobOpenings(final TransactionalContext autoTx) {
        return new JpaJobOpeningRepository(autoTx);
    }

    @Override
    public JpaJobOpeningRepository jobOpenings() {
        return new JpaJobOpeningRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public JpaApplicationRepository applications(final TransactionalContext autoTx) {
        return new JpaApplicationRepository(autoTx);
    }

    @Override
    public JpaApplicationRepository applications() {
        return new JpaApplicationRepository(Application.settings().getPersistenceUnitName());
    }


    @Override
    public JpaPluginRepository plugins(final TransactionalContext autoTx) {
        return new JpaPluginRepository(autoTx);
    }

    @Override
    public JpaPluginRepository plugins() {
        return new JpaPluginRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public RankRepository ranks(TransactionalContext autoTx) {
        return new JpaRankRepository(autoTx);
    }

    @Override
    public RankRepository ranks() {
        return new JpaRankRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public NotificationRepository notifications(TransactionalContext autoTx) {
        return new JpaNotificationRepository(autoTx);
    }

    @Override
    public NotificationRepository notifications() {
        return new JpaNotificationRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public TransactionalContext newTransactionalContext() {
        return JpaAutoTxRepository.buildTransactionalContext(Application.settings().getPersistenceUnitName(),
                Application.settings().getExtendedPersistenceProperties());
    }

}
