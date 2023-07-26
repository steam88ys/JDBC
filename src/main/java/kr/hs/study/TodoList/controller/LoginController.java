package kr.hs.study.TodoList.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "login_form";
    }

    @GetMapping("/todolist_form")
    public String todolist_form() {
        return "todolist_form";
    }
}
