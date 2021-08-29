package com.example.requestscopepoc;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EndpointEnumTest {

    @Test
    void getAllPaths() {
        var actual = EndpointEnum.getAllPaths();
        assertThat(actual).containsAll(List.of("/greetings"));
    }

    @Test
    void fromMethodAndPathGetGreetings() {
        var actual = EndpointEnum.fromMethodAndPath("GET", "/greetings");
        assertThat(actual).isEqualTo(Optional.of(EndpointEnum.GET_GREETINGS));
    }

    @Test
    void fromMethodAndPathGetOther() {
        var actual = EndpointEnum.fromMethodAndPath("GET", "/actuator/health");
        assertThat(actual).isEqualTo(Optional.empty());
    }
}