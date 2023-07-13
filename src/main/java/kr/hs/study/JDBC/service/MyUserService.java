package kr.hs.study.JDBC.service;

import kr.hs.study.JDBC.dto.MyUserDTO;

import java.util.List;

public interface MyUserService {

    public void insert(MyUserDTO dto);

    public List<MyUserDTO> listAll ();

}
