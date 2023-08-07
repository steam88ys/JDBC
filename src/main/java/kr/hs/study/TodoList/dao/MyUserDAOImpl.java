package kr.hs.study.TodoList.dao;

import kr.hs.study.TodoList.dto.MyUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyUserDAOImpl implements MyUserDAO {
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public void insert(MyUserDTO dto) {
        String sql = "insert into usertbl(uname,email,upass) values(?,?,?)";
        jdbc.update(sql, dto.getUname(), dto.getEmail(), dto.getUpass());
    }

}
