package kr.hs.study.JDBC.service;

import kr.hs.study.JDBC.dao.MyUserDAO;
import kr.hs.study.JDBC.dto.MyUserDTO;
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

    @Override
    public List<MyUserDTO> listAll() {
        return null;
    }
}
