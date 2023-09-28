package com.example.movement.models;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "bankingProduct")
@Data
public class BankingProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    private String customerType;
    @NotEmpty
    private String status;
    @NotNull
    private float balance;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date registrationDate;
    @ManyToOne
    //@JsonIgnore
    @JoinColumn(name = "bankId")
    private Bank bank;
    @OneToMany
    @JoinColumn(name = "bankingProductId")
    private List<Movement> movements;
}
