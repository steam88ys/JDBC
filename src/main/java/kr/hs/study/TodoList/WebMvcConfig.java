package kr.hs.study.TodoList;

import kr.hs.study.TodoList.LoggedInInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final LoggedInInterceptor loggedInInterceptor;

    @Autowired
    public WebMvcConfig(LoggedInInterceptor loggedInInterceptor) {
        this.loggedInInterceptor = loggedInInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggedInInterceptor)
                .addPathPatterns("/todolist")
                .addPathPatterns("/todolist_form")
                .addPathPatterns("/getTodoList");
    }
}

