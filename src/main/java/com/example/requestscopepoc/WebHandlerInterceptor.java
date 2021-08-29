package com.example.requestscopepoc;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
@Slf4j
public class WebHandlerInterceptor implements HandlerInterceptor {

    private final RequestContext requestContext;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.debug("Request Context (24) {}", requestContext);
        var method = request.getMethod();
        var contextPath = request.getContextPath();
        var endPoint = EndpointEnum.fromMethodAndPath(method, contextPath);
        if (endPoint.isPresent()) {
            log.debug("Processing HTTP {} {}", method, contextPath);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        log.debug("Request Context (30) {}", requestContext);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        log.debug("Request Context (37) {}", requestContext);
    }
}
