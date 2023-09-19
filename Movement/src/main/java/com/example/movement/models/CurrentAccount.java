package com.example.movement.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class CurrentAccount extends PassiveBankingProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull
    private float maintenanceCommissionAmount;
    @ManyToMany
    @JoinTable(name = "accountHolder",
            joinColumns = @JoinColumn(name = "current_account_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private List<Customer> accountsHolder;
    @ManyToMany
    @JoinTable(name = "signatory",
            joinColumns = @JoinColumn(name = "current_account_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private List<Customer> signatories;

}
