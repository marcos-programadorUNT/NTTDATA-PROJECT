package com.example.movement.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "movement")
@Data
public class Movement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    private String movementType;
    @NotEmpty
    private String status;
    @NotNull
    private float moneyRequired;
    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date registrationDate;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "bankingProductId")
    private BankingProduct bankingProduct;
}
