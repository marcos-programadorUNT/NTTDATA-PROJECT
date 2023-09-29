package com.example.bankingproductclient.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;


/**
 * BusinessCustomer class that inherits from Customer.
 * Has te business information.
 *
 */
@Entity
@DiscriminatorValue("business")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BusinessCustomer extends Customer{
    @Column(name = "business_name")
    @NotEmpty(message = "The business name should not be empty")
    private String businessName;
    @Column(name = "ruc", unique = true)
    @NotEmpty(message = "The RUC should not be empty")
    @Size(min = 11, max = 11, message = "The RUC should be 11 characters")
    private String ruc;
    @Column(name = "foundation_date")
    @NotNull(message = "The foundation date should not be empty")
    private LocalDate foundationDate;
}
