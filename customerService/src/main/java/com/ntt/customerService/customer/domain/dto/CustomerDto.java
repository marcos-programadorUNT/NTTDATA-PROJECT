package com.ntt.customerService.customer.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * Dto for Customer to allow update and create methods with heritage
 *
 */
@Setter
@Getter
public class CustomerDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "The email should not be empty")
    @Email
    private String email;
    @NotNull(message = "The address should not be empty")
    private String address;
    @NotNull(message = "The phone number should not be empty")
    private String phoneNumber;
    @NotNull(message = "The status should not be empty")
    private String status;


    private String firstName;
    private String lastName;
    private String documentNumber;
    private LocalDate dateOfBirth;

    private String businessName;
    private String ruc;
    private LocalDate foundationDate;
}
