package kr.hs.study.JDBC.dao;

import kr.hs.study.JDBC.dto.MyUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyUserDAOImpl implements MyUserDAO {
    @Autowired  // Autowired로 JdbcTemplate 자동 주입
    JdbcTemplate jdbc;

    @Override
    public void insert(MyUserDTO dto) {
        String sql = "insert into usertbl(uname,email,upass) values(?,?,?)";
        jdbc.update(sql, dto.getName(), dto.getEmail(), dto.getPass());
    }

    @Override
    public List<MyUserDTO> listAll() {
        return null;
    }

    @Override
    public void delete(String id) {
        String sql = "delete from usertbl where id='B';";
    }
}
