package kr.hs.study.TodoList.controller;

import kr.hs.study.TodoList.dto.TodoDTO;
import kr.hs.study.TodoList.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

//    @PostMapping("/todolist_form")
//    public String todolist(TodoDTO dto) {
//        service.insert(dto);
//        return "todolist";
//    }

    @PostMapping("/todolist_form")
    public String list(TodoDTO dto, Model model) {
        service.insert(dto);
        List<TodoDTO> list = service.listAll();
        model.addAttribute("list1", list);
        return "todolist";
    }

}
