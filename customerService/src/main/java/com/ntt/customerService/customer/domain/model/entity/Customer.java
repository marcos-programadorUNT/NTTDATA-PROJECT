package com.ntt.customerService.customer.domain.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
public abstract class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email", length = 25, nullable = false)
    private String email;
    @Column(name= "address", length = 50, nullable = false)
    private String address;
    @Column(name= "status", nullable = false)
    private String status;
    @Column(name = "customer_type", insertable = false, updatable = false)
    private String customerType;

}
