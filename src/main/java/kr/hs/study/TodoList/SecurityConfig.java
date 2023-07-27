package kr.hs.study.TodoList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // 설정
        http.authorizeRequests(customizer -> {
            customizer.antMatchers("/", "/write", "/write-form", "/css/**").permitAll().anyRequest().authenticated();
        });
        http.csrf().disable();
        http.formLogin(customizer -> {
            customizer
                    .loginPage("/login")
                    .loginProcessingUrl("/login_proc")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .defaultSuccessUrl("/todolist")
                    .failureUrl("/login?error")
                    .permitAll();
        });
        http.logout(customizer -> {
            customizer
                    .logoutUrl("/logout") // 로그아웃 URL
                    .logoutSuccessUrl("/login") // 로그아웃 성공 시 리다이렉트 URL
                    .invalidateHttpSession(true) // HTTP 세션 무효화
                    .deleteCookies("JSESSIONID"); // 로그아웃 시 쿠키 삭제 (여기서는 세션 ID 쿠키만 삭제)

        });

        return http.build();
    }
}
