package com.example.bankingproductclient.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * PersonalCustomer class that inherits from Customer
 * Has te personal information
 *
 */
@Entity
@DiscriminatorValue("business_credit")
@Getter
@Setter
@AllArgsConstructor
//@SuperBuilder
public class BusinessCredit extends ActiveBankingProduct{
    @Column(name = "debt_ammount")
    //@NotNull(message = "The monthly_movement_limit should not be empty")
    private float debtAmount;

    public BusinessCredit() {
        this.debtAmount = 0.0f;
    }
}
