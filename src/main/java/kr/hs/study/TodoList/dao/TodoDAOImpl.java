package kr.hs.study.TodoList.dao;

import kr.hs.study.TodoList.dto.TodoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.apache.tomcat.jni.File.trunc;

@Repository
public class TodoDAOImpl implements TodoDAO{
    @Autowired  // Autowired로 JdbcTemplate 자동 주입
    JdbcTemplate jdbc;

    @Override
    public void insert(TodoDTO dto) {
        String sql = "INSERT INTO todotbl (todo_id, todo_list, todo_date, star, user_email) " +
                "VALUES (todotbl_seq.NEXTVAL, ?, ?, ?, ?)";
        jdbc.update(sql, dto.getTodo_list(), dto.getTodo_date(), dto.getStar(), dto.getUser_email());
    }


    @Override
    public void delete(String id) {
        String sql = "delete from todotbl where todo_id="+id;
        jdbc.update(sql);
    }

    @Override
    public TodoDTO readOne(String id) {
        String sql = "select * from todotbl where todo_id="+id;
        TodoDTO dto = jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(TodoDTO.class));
        return dto;
    }

    @Override
    public List<TodoDTO> readDate(TodoDTO dto, String loggedInUserEmail, String todoDate) {
        String sql = "SELECT t.* FROM todotbl t INNER JOIN usertbl u ON t.user_email = u.email WHERE u.email = ? AND TRUNC(t.todo_date) = TO_DATE(?, 'YYYY-MM-DD')";
        List<TodoDTO> dtos = jdbc.query(sql, new BeanPropertyRowMapper<>(TodoDTO.class), loggedInUserEmail, todoDate);
        System.out.println(dtos);
        return dtos;
    }


    @Override
    public void update(TodoDTO dto) {
        String sql = "update todotbl set todo_list=?, todo_date=to_date(?,'yyyy-mm-dd hh24:mi:ss'), star=? where todo_id=?";
        jdbc.update(sql, dto.getTodo_list(), dto.getTodo_date(), dto.getStar(), dto.getTodo_id());
    }


    @Override
    public List<TodoDTO> listAll() {
        String sql = "select * from todotbl order by todo_date desc";
        List<TodoDTO> list = jdbc.query(sql, new BeanPropertyRowMapper<>(TodoDTO.class));
        return list;
    }

    @Override
    public List<TodoDTO> listAll(String loggedInUserEmail) {
        String sql = "SELECT t.* FROM todotbl t INNER JOIN usertbl u ON t.user_email = u.email WHERE u.email = ? and TRUNC(todo_date) = TRUNC(SYSDATE) ORDER BY t.todo_date DESC";

        Map<String, Object> userMap = jdbc.queryForMap("SELECT * FROM usertbl WHERE email = ?", loggedInUserEmail);
        if (userMap != null) {
            List<TodoDTO> list = jdbc.query(sql, new BeanPropertyRowMapper<>(TodoDTO.class), loggedInUserEmail);
            return list;
        } else {
            // 사용자 정보와 일치하지 않을 경우 처리
            return Collections.emptyList();
        }
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

    @Override
    public List<TodoDTO> calculateCubelist() {
        String sql = "SELECT\n" +
                "  todo_date,\n" +
                "  COUNT(*) AS total_tasks,\n" +
                // 전체 작업 수의 통합
                "  SUM(COUNT(*)) OVER() AS grand_total,\n" +
                // todo_date를 기준으로 작업 수의 누적 합
                "  SUM(COUNT(*)) OVER(ORDER BY todo_date) AS intermediate,\n" +
                // 날짜별 작업 수의 통합과 해당 날짜 이후까지의 작업 수 비교
                "  SUM(COUNT(*)) OVER() - SUM(COUNT(*)) OVER(ORDER BY todo_date) AS subtotal\n" +
                "FROM todotbl\n" +
                "GROUP BY todo_date\n" +
                "ORDER BY todo_date desc";

        List<TodoDTO> list = jdbc.query(sql, new BeanPropertyRowMapper<>(TodoDTO.class));
        return list;
    }

    @Override
    public List<TodoDTO> join(String loggedInUserEmail) {
        String sql = "SELECT usertbl.uname, todotbl.todo_date\n" +
                "FROM usertbl\n" +
                "INNER JOIN todotbl ON usertbl.email = todotbl.user_email\n" +
                "WHERE usertbl.email = ? AND todotbl.star = 5";

        Map<String, Object> userMap = jdbc.queryForMap("SELECT * FROM usertbl WHERE email = ?", loggedInUserEmail);
        if (userMap != null) {
            List<TodoDTO> list = jdbc.query(sql, new BeanPropertyRowMapper<>(TodoDTO.class), loggedInUserEmail);
            return list;
        } else {
            // 사용자 정보와 일치하지 않을 경우 처리
            return Collections.emptyList();
        }
    }


}
