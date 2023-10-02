package com.example.movementclient.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
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
//@NoArgsConstructor
//@AllArgsConstructor
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="passive_banking_product_type", discriminatorType = DiscriminatorType.STRING)
//@SuperBuilder
public class PassiveBankingProduct extends BankingProduct{
    /*
    @Column(name = "passive_banking_product_type", insertable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private PassiveBankingProductType passiveBankingProductType;
     */


    public PassiveBankingProduct() {
    }

}
