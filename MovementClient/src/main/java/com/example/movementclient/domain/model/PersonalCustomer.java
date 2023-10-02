package com.example.movementclient.domain.model;

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
public class PersonalCustomer extends Customer{
    @Column(name = "first_name")
    @NotEmpty(message = "The first name should not be empty")
    private String firstName;
    @Column(name = "last_name")
    @NotEmpty(message = "The last name should not be empty")
    private String lastName;
    @Column(name = "document_number", unique = true)
    @NotEmpty(message = "The document number should not be empty")
    @Size(min = 8, max = 8, message = "The document number should be 8 characters")
    private String documentNumber;
    @Column(name = "date_of_birth")
    @NotNull(message = "The date of birth should not be empty")
    private LocalDate dateOfBirth;
}
