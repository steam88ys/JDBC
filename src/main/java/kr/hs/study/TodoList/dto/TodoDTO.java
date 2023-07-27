package kr.hs.study.TodoList.dto;

import lombok.Data;

@Data
public class TodoDTO {
    private String todo_list;
    private String todo_date;
    private int checkedCount; // 총 별의 갯수를 저장하는 필드

    public String getTodo_list() {
        return todo_list;
    }

    public String getTodo_date() {
        return todo_date;
    }

    // getter 메서드에서 총 별의 갯수를 반환하도록 수정
    public int getStar() {
        return checkedCount;
    }

}
