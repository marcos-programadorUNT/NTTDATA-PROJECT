package com.example.bankingproductclient.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * PersonalCustomer class that inherits from Customer
 * Has te personal information
 *
 */
@Entity
@DiscriminatorValue("passive_banking_product")
@Getter
@Setter
public class PassiveBankingProduct extends BankingProduct{

    public PassiveBankingProduct(Integer id, @NotEmpty(message = "The status should not be empty") String status, @NotEmpty(message = "The status should not be empty") String mainBankingProductType, @NotNull float balance, @NotNull(message = "The registration_date should not be empty") Date registrationDate, Bank bank, List<Movement> movements, Customer customer, BankingProductType bankingProductType) {
        super(id, status, mainBankingProductType, balance, registrationDate, bank, movements, customer, bankingProductType);
    }

    public PassiveBankingProduct() {
    }
}
