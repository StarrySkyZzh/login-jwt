package com.chilly.config;

import com.chilly.interceptors.JWTInterceptor;
import com.chilly.interceptors.StudentInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor())
                .addPathPatterns("/user/test")
                .addPathPatterns("/student/**")
                .addPathPatterns("/teacher/**")
                .excludePathPatterns("/login")
        ;
    }
}
