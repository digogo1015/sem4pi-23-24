package lapr4.jobs4u.jobopeningmanagement.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;
import lapr4.jobs4u.usermanagement.domain.UserRoles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class EditJobOpeningController {

    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private static final List<String> EDITABLE_FIELDS = Arrays.asList(
            "jobTitle","description","address","jobOpeningMode","contractType","numberOfVacancies"
    );

    // returns a list of all job openings
    public List<JobOpening> getListOfJobOpenings() {

        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.ADMIN, UserRoles.CUSTOMER_MANAGER);

        Iterable<JobOpening> jobOpenings = jobOpeningRepository.jobOpeningByManager(authz.session().get().authenticatedUser());

        return StreamSupport.stream(jobOpenings.spliterator(), false)
                .collect(Collectors.toList());

    }

    // returns a list of all editable fields
    public List<String> getEditableFields() {
        return new ArrayList<>(EDITABLE_FIELDS);
    }


    public boolean editJobTitle(JobOpening jobOpening, String newValue) {
        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.ADMIN, UserRoles.CUSTOMER_MANAGER);
        jobOpening.editJobTitle(newValue);
        jobOpeningRepository.save(jobOpening);
        return true;
    }

    public boolean editDescription(JobOpening jobOpening, String newValue) {
        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.ADMIN, UserRoles.CUSTOMER_MANAGER);
        jobOpening.editDescription(newValue);
        jobOpeningRepository.save(jobOpening);
        return true;
    }

    public boolean editAddress(JobOpening jobOpening, String street, String city, String state) {
        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.ADMIN, UserRoles.CUSTOMER_MANAGER);
        jobOpening.editAddress(street, city, state);
        jobOpeningRepository.save(jobOpening);
        return true;
    }

    public boolean editJobOpeningMode(JobOpening jobOpening, String newValue) {
        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.ADMIN, UserRoles.CUSTOMER_MANAGER);
        jobOpening.editJobOpeningMode(newValue);
        jobOpeningRepository.save(jobOpening);
        return true;
    }

    public boolean editContractType(JobOpening jobOpening, String newValue) {
        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.ADMIN, UserRoles.CUSTOMER_MANAGER);
        jobOpening.editContractType(newValue);
        jobOpeningRepository.save(jobOpening);
        return true;
    }

    public boolean editNumberOfVacancies(JobOpening jobOpening, int newValue) {
        authz.ensureAuthenticatedUserHasAnyOf(UserRoles.POWER_USER, UserRoles.ADMIN, UserRoles.CUSTOMER_MANAGER);
        jobOpening.editNumberOfVacancies(newValue);
        jobOpeningRepository.save(jobOpening);
        return true;
    }





}


