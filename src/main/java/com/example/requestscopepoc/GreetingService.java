package com.example.requestscopepoc;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class GreetingService {

    private final RequestContext requestContext;

    public String getGreeting(String name) {
        log.debug("Request Context (17) {}", requestContext.getId());
        requestContext.setId(UUID.randomUUID());
        log.debug("Request Context (19) {}", requestContext.getId());
        return String.format("Hello %s!",  name);
    }

}
