package com.example.requestscopepoc;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@ToString
@Slf4j
public enum EndpointEnum {

    GET_GREETINGS("GET", "/greetings");

    private final String method;
    private final String path;

    EndpointEnum(String method, String path) {
        this.method = method;
        this.path = path;
    }

    public static List<String> getAllPaths() {
        return Stream.of(EndpointEnum.values())
                .map(e -> e.path)
                .distinct()
                .collect(Collectors.toList());
    }

    public static Optional<EndpointEnum> fromMethodAndPath(final String method, final String requestPath) {
        return Stream.of(EndpointEnum.values())
                .peek(entrypoint -> log.debug("Verifying {}", entrypoint))
                .filter(entrypoint -> {
                    String replacement = entrypoint.path.replace("/*/", "/.+/");
                    replacement = replacement.replace("/*", "(/[^\\/]+)");
                    replacement = "^(" + replacement + ")$";
                    log.debug("Testing request path {} matches {}", requestPath, replacement);
                    return requestPath.matches(replacement) && entrypoint.method.equalsIgnoreCase(method);
                })
                .findFirst();
    }
}
