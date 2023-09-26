package com.ntt.customerService.customer.domain.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Entity of the Customer object that defines all his common attributes
 * Customer parent class
 *
 */
@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="customer_type", discriminatorType = DiscriminatorType.STRING)

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email", length = 25, nullable = false)
    @NotNull(message = "The email should not be empty")
    private String email;
    @Column(name= "address", length = 50, nullable = false)
    @NotNull(message = "The address should not be empty")
    private String address;
    @Column(name = "phone_number", nullable = false)
    @NotNull(message = "The phone number should not be empty")
    private String phoneNumber;
    @Column(name= "status", nullable = false)
    @NotNull(message = "The status should not be empty")
    private String status;
    @Column(name = "customer_type", insertable = false, updatable = false)
    private String customerType;

}
