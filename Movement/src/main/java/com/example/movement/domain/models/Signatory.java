package com.example.movement.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "Signatory")
@Data
public class Signatory implements Serializable {
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
    @NotEmpty
    private String status;
}
