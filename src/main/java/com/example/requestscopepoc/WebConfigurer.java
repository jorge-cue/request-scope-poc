package com.example.requestscopepoc;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Component
@RequiredArgsConstructor
@Slf4j
public class WebConfigurer extends WebMvcConfigurationSupport {

    private final WebHandlerInterceptor webHandlerInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        log.debug("Adding interceptor");
        registry.addInterceptor(webHandlerInterceptor);
    }
}
