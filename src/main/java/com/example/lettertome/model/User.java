package com.example.lettertome.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

    //JoinColumn은 외래키 주인에게만!
    @OneToMany
    private List<Board> board;
}
