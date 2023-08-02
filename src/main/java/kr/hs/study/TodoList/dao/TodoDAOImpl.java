package kr.hs.study.TodoList.dao;

import kr.hs.study.TodoList.dto.MyUserDTO;
import kr.hs.study.TodoList.dto.TodoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
    public void delete(String id) {
        String sql = "delete from todotbl where todo_id="+id;
        jdbc.update(sql);
    }

    @Override
    public List<TodoDTO> listAll() {
        String sql = "select * from todotbl order by todo_date desc";
        List<TodoDTO> list = jdbc.query(sql, new BeanPropertyRowMapper<>(TodoDTO.class));
        return list;
    }

    @Override
    public List<TodoDTO> getTodoListByLatest() {
        String sql = "select * from todotbl order by todo_date desc";
        List<TodoDTO> list = jdbc.query(sql, new BeanPropertyRowMapper<>(TodoDTO.class));
        return list;
    }

    @Override
    public List<TodoDTO> getTodoListByOldest() {
        String sql = "select * from todotbl order by todo_date asc";
        List<TodoDTO> list = jdbc.query(sql, new BeanPropertyRowMapper<>(TodoDTO.class));
        return list;
    }

    @Override
    public List<TodoDTO> getTodoListByPriority() {
        String sql = "select * from todotbl order by star desc";
        List<TodoDTO> list = jdbc.query(sql, new BeanPropertyRowMapper<>(TodoDTO.class));
        return list;
    }

    @Override
    public List<TodoDTO> getTodoListCube() {
        String sql = "SELECT todo_date, COUNT(*) as total_tasks\n" +
                "        FROM todotbl\n" +
                "        GROUP BY CUBE(todo_date)";
        List<TodoDTO> list = jdbc.query(sql, new BeanPropertyRowMapper<>(TodoDTO.class));
        return list;
    }

}
