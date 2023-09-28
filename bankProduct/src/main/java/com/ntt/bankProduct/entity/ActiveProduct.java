package com.ntt.bankProduct.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "active_product")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ActiveProduct extends BankProduct {
    private String type;
}
