package com.example.movementclient.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * PersonalCustomer class that inherits from Customer
 * Has te personal information
 *
 */
@Entity
@DiscriminatorValue("savings_account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@SuperBuilder
public class SavingsAccount extends PassiveBankingProduct{
    @Column(name = "monthly_movement_limit", nullable = false)
    @NotNull(message = "The monthly_movement_limit should not be empty")
    private byte monthlyMovementLimit;

    /*
    @Override
    public Integer getId() {
        return super.getId();
    }

    @Override
    public void setId(Integer id) {
        super.setId(id);
    }
*/
    
}
