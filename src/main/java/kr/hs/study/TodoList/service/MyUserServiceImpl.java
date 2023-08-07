package kr.hs.study.TodoList.service;

import kr.hs.study.TodoList.dao.MyUserDAO;
import kr.hs.study.TodoList.dto.MyUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserServiceImpl implements MyUserService {
    @Autowired
    private MyUserDAO dao;

    @Override
    public void insert(MyUserDTO dto) {
        dao.insert(dto);
    }

}
