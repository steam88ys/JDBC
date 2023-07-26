package kr.hs.study.TodoList.dto;

import lombok.Data;

@Data
public class MyUserDTO {
    private String name;
    private String email;
    private String pass;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }
}
