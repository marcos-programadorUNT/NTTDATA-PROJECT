package com.ntt.bankProduct.entity;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="customer_type", discriminatorType = DiscriminatorType.STRING)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email", length = 25, nullable = false)
    private String email;
    @Column(name= "address", length = 50, nullable = false)
    private String address;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(name= "status", nullable = false)
    private String status;
    @Column(name = "customer_type", insertable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private CustomerType customerType;
}
