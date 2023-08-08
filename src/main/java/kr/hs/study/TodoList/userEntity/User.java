package kr.hs.study.TodoList.userEntity;


import javax.persistence.*;

@Entity
@Table(name = "usertbl2")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uname;
    private String upass;

}

