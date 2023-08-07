package kr.hs.study.TodoList.controller;

import kr.hs.study.TodoList.dto.MyUserDTO;
import kr.hs.study.TodoList.dto.TodoDTO;
import kr.hs.study.TodoList.service.MyUserService;
import kr.hs.study.TodoList.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyUserController {
    @Autowired
    private MyUserService service;

    @GetMapping("/write")
    public String write() {
        return "write_form";
    }

    @PostMapping("/write_form")
    public String write_form(MyUserDTO dto) {
        System.out.println(dto);
        service.insert(dto);
        return "redirect:/login";
    }

}
