package com.example.movement.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
public class PassiveBankingProduct extends BankingProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotEmpty
    private String passiveBankingProductType;
}
