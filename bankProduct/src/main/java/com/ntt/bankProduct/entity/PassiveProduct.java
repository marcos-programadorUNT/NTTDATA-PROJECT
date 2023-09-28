package com.ntt.bankProduct.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "passive_product")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PassiveProduct extends BankProduct {
    private String type;
}
