package com.example.lettertome.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number")
    private Integer number;

    @Column(name = "id", updatable = false)
    private String id;

    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

    @Transient
    private String newpassword;

    //JoinColumn은 외래키 주인에게만!
    //앵간하면 안 쓰는게 좋다고...???
    //얘를 굳이 가지고 있을 필요는 없음 ?? ?
    //일반적으로는 얘가 성능을 다 잡아먹어서 많이 안쓴다고........?
//    @OneToMany(mappedBy = "user")
//    private List<Board> boards;
}
