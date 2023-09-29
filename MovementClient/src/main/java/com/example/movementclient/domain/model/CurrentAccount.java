package com.example.movementclient.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * PersonalCustomer class that inherits from Customer
 * Has te personal information
 *
 */
@Entity
@DiscriminatorValue("current_account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CurrentAccount extends PassiveBankingProduct{
    @Column(name = "maintenance_commission_amount", columnDefinition = "DECIMAL(7,2)", nullable = false)
    @NotNull(message = "The maintenance_commission_amount should not be empty")
    private float maintenanceCommissionAmount;
    @ManyToMany
    @JoinTable(name = "account_holders",
            joinColumns = @JoinColumn(name = "current_account_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private List<Customer> accountsHolder;
    @ManyToMany
    @JoinTable(name = "signatories",
            joinColumns = @JoinColumn(name = "current_account_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private List<Customer> signatories;
}
