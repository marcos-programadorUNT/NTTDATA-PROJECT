package com.example.movement.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
//@Table(name = "savingsAccount")
@Data
public class SavingsAccount extends PassiveBankingProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull
    private byte monthlyMovementLimit;
}
