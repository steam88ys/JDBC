package kr.hs.study.TodoList.userEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User login(String uname, String upass) {
        User user = userRepository.findByUnameAndUpass(uname, upass);
        return user; // 일치하는 사용자가 없으면 null, 일치하는 사용자가 있으면 해당 User 객체 반환
    }
}


