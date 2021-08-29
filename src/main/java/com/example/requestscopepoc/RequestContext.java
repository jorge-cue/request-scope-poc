package com.example.requestscopepoc;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.UUID;

@Component
@RequestScope
@Data
public class RequestContext {
    private UUID id;
    private String name;
}
