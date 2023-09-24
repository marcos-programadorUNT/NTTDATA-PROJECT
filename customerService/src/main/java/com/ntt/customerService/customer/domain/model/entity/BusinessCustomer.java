package com.ntt.customerService.customer.domain.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * BusinessCustomer class that inherits from Customer
 * Has te business information
 *
 */
@Entity
@DiscriminatorValue("business")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class BusinessCustomer extends Customer{
    @Column(name = "business_name")
    private String businessName;
    @Column(name = "ruc", unique = true)
    private String ruc;
    @Column(name = "foundation_date")
    private LocalDate foundationDate;


}
