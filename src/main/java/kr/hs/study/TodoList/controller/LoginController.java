package kr.hs.study.TodoList.controller;

import kr.hs.study.TodoList.dto.TodoDTO;
import kr.hs.study.TodoList.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    private TodoService service;

    @GetMapping("/login")
    public String login() {
        return "login_form";
    }

    @GetMapping("/todolist")
    public String todolist_form() {
        return "todolist_form";
    }

    @PostMapping("/todolist_form")
    public String todolist_form(TodoDTO dto) {
        service.insert(dto);
        return "result";
    }
}
