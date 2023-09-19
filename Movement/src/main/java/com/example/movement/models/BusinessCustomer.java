package com.example.movement.models;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Entity
@Data
public class BusinessCustomer extends Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotEmpty
    private String businessName;
    @NotEmpty
    private String ruc;
}
