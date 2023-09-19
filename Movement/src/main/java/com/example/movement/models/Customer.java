package com.example.movement.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "customer")
@Data
public class Customer {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    private String email;
    @NotEmpty
    private String direction;
    @NotEmpty
    private String status;
}
