package com.ntt.bankProduct.entity;
import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bank_product")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BankProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double balance;
    private String client;
    @Column(name = "date_cr")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    private String status;
}
