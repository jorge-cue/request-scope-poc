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
        log.debug("Request Context (17) {}", requestContext);
        requestContext.setId(UUID.randomUUID());
        requestContext.setName(name);
        log.debug("Request Context (19) {}", requestContext);
        return String.format("Hello %s!",  name);
    }

}
