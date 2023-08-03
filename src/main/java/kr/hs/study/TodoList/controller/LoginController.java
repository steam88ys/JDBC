package kr.hs.study.TodoList.controller;

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

    @GetMapping("/todolist_form")
    public String listAll(TodoDTO dto, Model model) {
        List<TodoDTO> list = service.listAll();
        model.addAttribute("list", list);
        List<TodoDTO> cubelist = service.getTodoListCube();
        model.addAttribute("cubelist", cubelist);
        return "todolist";
    }

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

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") String id, Model model) {
        // select로 내용 가져오기
        TodoDTO dto = service.readOne(id);
        model.addAttribute("dto", dto);
        System.out.println("update");
        return "update_form";
    }

    @PostMapping("/update_done")
    public String update_done(TodoDTO dto) {
        service.update(dto);
        return "redirect:/todolist";
    }

}
