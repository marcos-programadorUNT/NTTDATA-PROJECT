package com.ntt.customerService.customer.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Dto for Customer to allow update and create methods with heritage
 *
 */
@Setter
@Getter
public class CustomerDto {
    private Long id;
    private String email;
    private String address;
    private String status;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String documentNumber;
    private LocalDate dateOfBirth;

    private String businessName;
    private String ruc;
    private LocalDate foundationDate;
}
