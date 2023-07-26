package kr.hs.study.TodoList.service;

import kr.hs.study.TodoList.dto.MyUserDTO;

import java.util.List;

public interface MyUserService {

    public void insert(MyUserDTO dto);

    public List<MyUserDTO> listAll ();

    public void delete(String id);

}
