package com.example.lettertome.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer user_id;

    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

}
