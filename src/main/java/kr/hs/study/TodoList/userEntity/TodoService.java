package kr.hs.study.TodoList.userEntity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class TodoService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void saveTodoWithUserEmail(User user) {
        String userEmail = user.getEmail();
        Todo todo = new Todo();
        todo.setUser_email(userEmail);
        entityManager.persist(todo);
    }
}

