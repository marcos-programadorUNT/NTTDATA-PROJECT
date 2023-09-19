package com.example.movement.models;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.*;
@Entity
@Data
public class PersonalCustomer extends Customer implements Serializable{
    private static final long serialVersionUID = 1L;
    @NotEmpty
    private String names;
    @NotEmpty
    private String surnames;
    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dateBirth;
}
