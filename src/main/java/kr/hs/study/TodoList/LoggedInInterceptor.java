package kr.hs.study.TodoList;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoggedInInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");

        if (user == null) {
            // 로그인되지 않은 상태라면 로그인 페이지로 리다이렉트
            response.sendRedirect("/login");
            return false;
        }

        return true; // 로그인된 상태면 핸들러 실행
    }
}
