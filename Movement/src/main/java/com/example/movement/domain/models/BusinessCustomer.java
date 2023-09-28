package com.example.movement.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class BusinessCustomer extends Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotEmpty
    private String businessName;
    @NotEmpty
    private String ruc;
    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date foundationDate;
}
