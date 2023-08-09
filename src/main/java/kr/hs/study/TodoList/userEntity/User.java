package kr.hs.study.TodoList.userEntity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "usertbl")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String uname;
    private String upass;

}

