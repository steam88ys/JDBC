package kr.hs.study.TodoList.service;

import kr.hs.study.TodoList.dto.TodoDTO;

import java.util.List;

public interface TodoService {
    public void insert(TodoDTO dto);

    public List<TodoDTO> listAll ();

    List<TodoDTO> getTodoListByLatest();
    List<TodoDTO> getTodoListByOldest();
    List<TodoDTO> getTodoListByPriority();

}
