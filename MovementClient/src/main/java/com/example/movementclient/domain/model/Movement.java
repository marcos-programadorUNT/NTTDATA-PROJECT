package com.example.movementclient.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "movements")
/*
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
 */
@Data
public class Movement{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "movement_type", nullable = false)
    @NotEmpty(message = "The movement_type should not be empty")
    private String movementType;
    @Column(name = "status", nullable = false)
    @NotEmpty(message = "The status should not be empty")
    private String status;
    @Column(name = "money_required", nullable = false)
    @NotNull(message = "The money_required should not be empty")
    private float moneyRequired;
    @Column(name = "registration_date", nullable = false)
    @NotNull(message = "The registration_date should not be empty")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date registrationDate;
    @ManyToOne
    //@JsonIgnore
    @JsonIgnoreProperties("movements")
    @JoinColumn(name = "bankingProductId")
    private BankingProduct bankingProduct;
}
