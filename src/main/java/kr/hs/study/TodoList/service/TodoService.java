package kr.hs.study.TodoList.service;

import kr.hs.study.TodoList.dto.TodoDTO;

import java.util.List;

public interface TodoService {
    public void insert(TodoDTO dto);
    public void delete (String id);

    public TodoDTO readOne(String id);
    public List<TodoDTO> readDate(TodoDTO dto, String loggedInUserEmail, String todoDate);
    public void update(TodoDTO dto);

    public List<TodoDTO> listAll ();

    List<TodoDTO> listAll(String loggedInUserEmail);

    List<TodoDTO> getTodoListByLatest();
    List<TodoDTO> getTodoListByOldest();
    List<TodoDTO> getTodoListByPriority();

    public List<TodoDTO> calculateCubelist();

    public List<TodoDTO> getTodoListCube();

    public List<TodoDTO> join(String loggedInUserEmail);

}
