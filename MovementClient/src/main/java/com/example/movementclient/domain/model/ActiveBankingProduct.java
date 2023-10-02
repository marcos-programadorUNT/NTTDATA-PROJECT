package com.example.movementclient.domain.model;

import lombok.AllArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * PersonalCustomer class that inherits from Customer
 * Has te personal information
 *
 */
@Entity
@DiscriminatorValue("active_banking_product")
@AllArgsConstructor
public class ActiveBankingProduct extends BankingProduct{
}
