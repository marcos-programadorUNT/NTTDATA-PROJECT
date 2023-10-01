package com.example.movementclient.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "banks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bank{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "business_name", length = 50, nullable = false)
    @NotEmpty(message = "The business_name should not be empty")
    private String businessName;
    @Column(name = "direction", length = 100, nullable = false)
    @NotEmpty(message = "The direction should not be empty")
    private String direction;
    @Column(name = "status", length = 8, nullable = false)
    @NotEmpty(message = "The status should not be empty")
    private String status;
    @OneToMany
    @JoinColumn(name = "bankId")
    private List<BankingProduct> bankingProducts;
}
