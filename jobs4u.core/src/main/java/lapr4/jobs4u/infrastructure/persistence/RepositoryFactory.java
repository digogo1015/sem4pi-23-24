package lapr4.jobs4u.infrastructure.persistence;

import lapr4.jobs4u.applicationmanagement.repository.ApplicationRepository;
import lapr4.jobs4u.candidatemanagement.repositories.CandidateRepository;
import lapr4.jobs4u.customermanagement.repositories.CustomerRepository;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;
import lapr4.jobs4u.notificationmanagement.repositories.NotificationRepository;
import lapr4.jobs4u.pluginmanagement.repositories.PluginRepository;
import lapr4.jobs4u.rankmanagement.repositories.RankRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;

public interface RepositoryFactory {

    /**
     * factory method to create a transactional context to use in the repositories
     *
     * @return
     */
    TransactionalContext newTransactionalContext();

    /**
     * @param autoTx the transactional context to enrol
     * @return
     */
    UserRepository users(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    UserRepository users();

    /**
     * @param autoTx the transactional context to enroll
     * @return
     */
    CustomerRepository customers(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    CustomerRepository customers();

    /**
     * @param autoTx the transactional context to enroll
     * @return
     */
    CandidateRepository candidates(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    CandidateRepository candidates();

    /**
     * @param autoTx the transactional context to enroll
     * @return
     */
    JobOpeningRepository jobOpenings(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    JobOpeningRepository jobOpenings();

    /**
     * @param autoTx the transactional context to enroll
     * @return
     */
    ApplicationRepository applications(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    ApplicationRepository applications();

    /**
     *
     * @param autoTx
     *            the transactional context to enroll
     * @return
     */
    PluginRepository plugins(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    PluginRepository plugins();

    /**
     * @param autoTx the transactional context to enroll
     * @return
     */
    RankRepository ranks(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    RankRepository ranks();

    /**
     *
     * @param autoTx
     *            the transactional context to enroll
     * @return
     */
    NotificationRepository notifications(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    NotificationRepository notifications();

}
