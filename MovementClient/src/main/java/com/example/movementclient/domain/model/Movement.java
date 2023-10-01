package com.example.movementclient.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "movements")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movement{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "movement_type", length = 1, nullable = false)
    @NotEmpty(message = "The movement_type should not be empty")
    private String movementType;
    @Column(name = "status", length = 8, nullable = false)
    @NotEmpty(message = "The status should not be empty")
    private String status;
    @Column(name = "money_required", columnDefinition = "DECIMAL(11,2)", nullable = false)
    @NotNull(message = "The money_required should not be empty")
    private float moneyRequired;
    @Column(name = "registration_date", nullable = false)
    @NotNull(message = "The registration_date should not be empty")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date registrationDate;
    @ManyToOne
    //@JsonIgnore
    @JoinColumn(name = "bankingProductId")
    private BankingProduct bankingProduct;
}
