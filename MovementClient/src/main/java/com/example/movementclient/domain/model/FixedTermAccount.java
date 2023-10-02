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
@DiscriminatorValue("fixed_term_account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FixedTermAccount extends PassiveBankingProduct{
    @Column(name = "specific_day_movement", nullable = false)
    @NotNull(message = "The specific_day_movement should not be empty")
    private byte specificDayMovement;
}
