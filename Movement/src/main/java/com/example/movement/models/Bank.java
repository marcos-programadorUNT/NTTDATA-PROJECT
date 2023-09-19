package com.example.movement.models;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "bank")
@Data
public class Bank implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    private String businessName;
    @NotEmpty
    private String direction;
    @NotEmpty
    private String status;
    @OneToMany
    @JoinColumn(name = "bankId")
    private List<BankingProduct> bankingProducts;
}
