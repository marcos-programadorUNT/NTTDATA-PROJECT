package com.ntt.bankProduct.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "fixed_term_account")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FixedTermAccount extends PassiveProduct
{
    @Column(name = "monthly_movement_day")
    private int movementDay;
}
