package com.example.requestscopepoc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class GreetingsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void getGreetings() throws Exception {
        mockMvc.perform(get("/greetings/{name}").param("name", "Jane Doe"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string("Hello Jane Doe!"));
    }
}
