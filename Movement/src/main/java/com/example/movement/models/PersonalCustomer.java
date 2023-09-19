package com.example.movement.models;
import lombok.Data;
import java.io.Serializable;
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
}
