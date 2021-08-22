package com.example.requestscopepoc;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/greetings")
@RequiredArgsConstructor
@Slf4j
public class GreetingsController {

    private final GreetingService greetingService;
    private final RequestContext requestContext;

    @GetMapping("/{name}")
    public ResponseEntity<String> getGreeting(@PathVariable String name) {
        log.debug("Request Context (23) {}", requestContext.getId());
        final String greeting = greetingService.getGreeting(name);
        log.debug("Request Context (25) {}", requestContext.getId());
        return ResponseEntity.ok(greeting);
    }

}
