package lapr4.jobs4u.customermanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jakarta.persistence.*;

@Entity
public class Customer implements AggregateRoot<CustomerCode> {

    private static final long serialVersionUID = 1L;

    @Version
    private Long version;

    @EmbeddedId
    private CustomerCode customerCode;

    private Address address;

    @ManyToOne
    private SystemUser manager;

    @OneToOne()
    private SystemUser systemUser;

    public Customer(final SystemUser user, final CustomerCode customerCode, final Address address, final SystemUser manager) {
        if (customerCode == null || user == null || address == null) {
            throw new IllegalArgumentException();
        }
        this.systemUser = user;
        this.customerCode = customerCode;
        this.address = address;
        this.manager = manager;
    }

    protected Customer() {
    }

    public SystemUser user() {
        return this.systemUser;
    }

    public Address address() {
        return this.address;
    }

    public SystemUser manager() {
        return this.manager;
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(final Object other) {
        return DomainEntities.areEqual(this, other);
    }

    public CustomerCode customerCode() {
        return identity();
    }

    @Override
    public CustomerCode identity() {
        return this.customerCode;
    }

    @Override
    public String toString() {
        return "Customer" +
                " CustomerCode: " + customerCode +
                " CompanyName: " + systemUser.name().firstName() +
                " Email: " + systemUser.email();
    }




}
