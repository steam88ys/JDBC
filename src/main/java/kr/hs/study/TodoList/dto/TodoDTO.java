package kr.hs.study.TodoList.dto;

import lombok.Data;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class TodoDTO {
    private Long todo_id;
    private String todo_list;
    private String todo_date;
    private int star; // 총 별의 갯수를 저장하는 필드
    private String user_email;
    private Integer total_tasks; // 총 작업 개수를 나타내는 필드 (계산된 값)

    public String getTodo_list() {
        return todo_list;
    }

    public String getTodo_date() {
        return todo_date;
    }

    public int getStar() {
        return star;
    }

}
