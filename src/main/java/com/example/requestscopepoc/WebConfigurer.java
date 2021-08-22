package com.example.requestscopepoc;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Component
@RequiredArgsConstructor
public class WebConfigurer extends WebMvcConfigurationSupport {

    private final GreetingsInterceptor greetingsInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(greetingsInterceptor);
    }
}
