package com.example.lettertome.model;

import lombok.Data;
import org.apache.tomcat.jni.Local;
import org.hibernate.annotations.CreationTimestamp;
import org.w3c.dom.Text;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private Boolean seeAuthority;

    @Column(name = "open_date")
    @CreationTimestamp
    private LocalDateTime open_date;

    @Column(name="created_date")
    @CreationTimestamp
    private LocalDateTime created_date;

    @Column(name="d_day")
    private Integer d_day;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name="user_id")
    private User user;


}
