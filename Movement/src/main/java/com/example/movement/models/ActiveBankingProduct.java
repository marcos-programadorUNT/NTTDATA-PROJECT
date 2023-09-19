package com.example.movement.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Data
public class ActiveBankingProduct extends BankingProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotEmpty
    private String activeBankingProductType;
}
