package com.example.movementclient.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Entity of the Customer object that defines all his common attributes
 * Customer parent class
 *
 */
@Entity
@Table(name = "banking_products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="banking_product_type", discriminatorType = DiscriminatorType.STRING)
//@SuperBuilder
public class BankingProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /*
    @Column(name = "customer_type", length = 1, nullable = false)
    @NotEmpty(message = "The customer_type should not be empty")
    private String customerType;
     */
    @Column(name = "status", length = 8, nullable = false)
    @NotEmpty(message = "The status should not be empty")
    private String status;

    @Column(name = "main_banking_product_type", length = 40, nullable = false)
    @NotEmpty(message = "The status should not be empty")
    private String mainBankingProductType;

    @Column(name = "balance", columnDefinition = "DECIMAL(11,2)", nullable = false)
    @NotNull
    private float balance;
    @Column(name = "registration_date", nullable = false)
    @NotNull(message = "The registration_date should not be empty")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date registrationDate;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "bankId")
    private Bank bank;
    @OneToMany
    @JoinColumn(name = "bankingProductId")
    private List<Movement> movements;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @Column(name = "banking_product_type", insertable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private BankingProductType bankingProductType;
}
