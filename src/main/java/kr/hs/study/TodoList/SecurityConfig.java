package kr.hs.study.TodoList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(customizer -> {
                    customizer
                            .antMatchers("/", "/write", "/write-form", "/css/**", "/signup").permitAll() // /signup 경로에 대해 인증이 필요하지 않도록 설정
                            .antMatchers("/delete/**").permitAll()
                            .anyRequest().authenticated();
                })
                .csrf().disable()
                .formLogin(customizer -> {
                    customizer
                            .loginPage("/login")
                            .loginProcessingUrl("/login_proc")
                            .usernameParameter("uname")
                            .passwordParameter("upass")
                            .defaultSuccessUrl("/todolist")
                            .failureUrl("/login?error")
                            .permitAll();
                })
                .logout(customizer -> {
                    customizer
                            .logoutUrl("/logout")
                            .logoutSuccessUrl("/login")
                            .invalidateHttpSession(true)
                            .deleteCookies("JSESSIONID");
                });

        return http.build();
    }
}
