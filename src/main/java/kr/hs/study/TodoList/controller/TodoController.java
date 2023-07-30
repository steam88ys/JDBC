package kr.hs.study.TodoList.controller;

import kr.hs.study.TodoList.dto.TodoDTO;
import kr.hs.study.TodoList.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/getTodoList")
    public List<TodoDTO> getTodoList(@RequestParam String orderBy) {
        List<TodoDTO> todoList;

        if ("oldest".equals(orderBy)) {
            todoList = todoService.getTodoListByOldest();
        } else if ("priority".equals(orderBy)) {
            todoList = todoService.getTodoListByPriority();
        } else {
            todoList = todoService.getTodoListByLatest();
        }

        return todoList;
    }

}
