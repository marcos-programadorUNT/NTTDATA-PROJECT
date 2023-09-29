package com.example.bankingproductclient.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * PersonalCustomer class that inherits from Customer
 * Has te personal information
 *
 */
@Entity
@DiscriminatorValue("passive_banking_product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="passive_banking_product_type", discriminatorType = DiscriminatorType.STRING)
public class PassiveBankingProduct extends BankingProduct{
    @Column(name = "passive_banking_product_type", insertable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private PassiveBankingProductType passiveBankingProductType;
}
