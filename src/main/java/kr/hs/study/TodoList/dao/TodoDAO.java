package kr.hs.study.TodoList.dao;

import kr.hs.study.TodoList.dto.MyUserDTO;
import kr.hs.study.TodoList.dto.TodoDTO;

import java.util.List;

public interface TodoDAO {
    public void insert (TodoDTO dto);
    public void delete (String id);
    public List<TodoDTO> listAll ();

    List<TodoDTO> getTodoListByLatest();
    List<TodoDTO> getTodoListByOldest();
    List<TodoDTO> getTodoListByPriority();

    List<TodoDTO> getTodoListCube();

}
