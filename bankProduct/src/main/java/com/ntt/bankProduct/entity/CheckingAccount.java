package com.ntt.bankProduct.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "checking_account")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CheckingAccount extends PassiveProduct{
    @Column(name = "commision_amount")
    private Double commissionAmount;
}
