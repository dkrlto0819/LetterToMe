package com.example.lettertome.model;

import lombok.Data;
import org.w3c.dom.Text;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
public class Board {
    @Id
    @Column(name = "board_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer board_id;

    @Column(name = "content")
    private String content;

    @Column(name = "see_authority")
    private Boolean see_authority;

    @Column(name = "open_date")
    private Date open_date;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

}