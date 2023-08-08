package kr.hs.study.TodoList.userEntity;


import javax.persistence.*;

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

