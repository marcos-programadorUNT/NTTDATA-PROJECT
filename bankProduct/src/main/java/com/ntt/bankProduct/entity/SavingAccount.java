package com.ntt.bankProduct.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "saving_account")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SavingAccount extends PassiveProduct {
    @Column(name = "movement_limit")
    private Double monthlyMovementLimit;
}
