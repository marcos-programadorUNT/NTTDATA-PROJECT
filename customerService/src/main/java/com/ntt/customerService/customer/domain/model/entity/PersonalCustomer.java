package com.ntt.customerService.customer.domain.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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


public class PersonalCustomer extends Customer {
    @Column(name = "first_name")
    @NotEmpty(message = "The first name should not be empty")
    private String firstName;
    @Column(name = "last_name")
    @NotEmpty(message = "The last name should not be empty")
    private String lastName;
    @Column(name = "phone_number")
    @NotEmpty(message = "The phone number should not be empty")
    private String phoneNumber;
    @Column(name = "document_number", unique = true)
    @NotEmpty(message = "The document number should not be empty")
    private String documentNumber;
    @Column(name = "date_of_birth")
    @NotNull(message = "The date of birth should not be empty")
    private LocalDate dateOfBirth;
}
