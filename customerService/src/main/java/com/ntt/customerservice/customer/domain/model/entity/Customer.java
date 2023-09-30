package com.ntt.customerservice.customer.domain.model.entity;



import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * Entity of the Customer object that defines all his common attributes.
 * Customer parent class.
 *
 */

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "customer_type", discriminatorType = DiscriminatorType.STRING)
@SuperBuilder

public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  @Column(name = "email", length = 25, nullable = false)
  @NotNull(message = "The email should not be empty")
  @Email
    private String email;
  @Column(name = "address", length = 50, nullable = false)
  @NotNull(message = "The address should not be empty")
    private String address;
  @Column(name = "phone_number", nullable = false)
  @NotNull(message = "The phone number should not be empty")
    private String phoneNumber;
  @Column(name = "status", nullable = false)
  @NotNull(message = "The status should not be empty")
    private String status;
  @Column(name = "customer_type", insertable = false, updatable = false)
  @Enumerated(EnumType.STRING)
    private CustomerType customerType;

}
