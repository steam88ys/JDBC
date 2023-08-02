package kr.hs.study.TodoList.controller;

import com.sun.tools.javac.comp.Todo;
import kr.hs.study.TodoList.dto.TodoDTO;
import kr.hs.study.TodoList.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("list", list);

        List<TodoDTO> cubelist = service.getTodoListCube();
        model.addAttribute("cubelist", cubelist);
        return "todolist";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        service.delete(id);
        return "redirect:/todolist";
    }

}
