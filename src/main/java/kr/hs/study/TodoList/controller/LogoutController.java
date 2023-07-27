package kr.hs.study.TodoList.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LogoutController {
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        // 세션에서 현재 로그인한 사용자 정보를 제거하여 로그아웃 처리
        request.getSession().removeAttribute("user");

        // 로그아웃 후 로그인 페이지로 리다이렉트
        return "redirect:/login";
    }
}
