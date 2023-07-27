package kr.hs.study.TodoList.dao;

import kr.hs.study.TodoList.dto.MyUserDTO;
import kr.hs.study.TodoList.dto.TodoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TodoDAOImpl implements TodoDAO{
    @Autowired  // Autowired로 JdbcTemplate 자동 주입
    JdbcTemplate jdbc;

    @Override
    public void insert(TodoDTO dto) {
        String sql = "INSERT INTO todotbl (todo_id, todo_list, todo_date, star) " +
                "VALUES (todotbl_seq.NEXTVAL, ?, ?, ?)";
        jdbc.update(sql, dto.getTodo_list(), dto.getTodo_date(), dto.getStar());
    }

    @Override
    public List<TodoDTO> listAll() {
        return null;
    }
}
