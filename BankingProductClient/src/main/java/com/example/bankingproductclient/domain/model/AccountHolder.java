package com.example.bankingproductclient.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "account_holders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountHolder implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "current_account_id")
    private CurrentAccount currentAccount;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @Column(name = "status", length = 8, nullable = false)
    @NotEmpty(message = "The status should not be empty")
    private String status;
}
