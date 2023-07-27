package kr.hs.study.TodoList.service;

import kr.hs.study.TodoList.dao.TodoDAO;
import kr.hs.study.TodoList.dto.TodoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    private TodoDAO dao;

    @Override
    public void insert(TodoDTO dto) {
        dao.insert(dto);
    }

    @Override
    public List<TodoDTO> listAll() {
        return dao.listAll();
    }
}
