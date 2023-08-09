package kr.hs.study.TodoList.userEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUnameAndUpass(String uname, String upass);
    User findByEmail(String email);
}



