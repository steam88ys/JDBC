package kr.hs.study.TodoList.userEntity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "todotbl")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todo_id;

    private String todo_list;
    private String todo_date;
    private String user_email; // 사용자 이메일 저장
    private int star;

}

