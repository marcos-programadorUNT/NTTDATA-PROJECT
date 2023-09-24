package com.ntt.customerService.customer.domain.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * PersonalCustomer class that inherits from Customer
 * Has te personal information
 *
 */
@Entity
@DiscriminatorValue("personal")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)


public class PersonalCustomer extends Customer {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "document_number", unique = true)
    private String documentNumber;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
}
