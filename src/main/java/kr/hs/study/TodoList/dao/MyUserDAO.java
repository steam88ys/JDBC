package kr.hs.study.TodoList.dao;

import kr.hs.study.TodoList.dto.MyUserDTO;

import java.util.List;

public interface MyUserDAO {
    //CRUD 메서드 정의
    
    // 1. 데이터 삽입
    public void insert (MyUserDTO dto);

    // 2. 데이터 가져오기
    public List<MyUserDTO> listAll ();
    
    // 3. 데이터 수정

    // 4. 데이터 삭제
    // id가 B인 애 삭제
    public void delete(String id);

}
