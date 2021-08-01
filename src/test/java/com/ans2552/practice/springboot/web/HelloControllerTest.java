package com.ans2552.practice.springboot.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void returnHello() throws  Exception {
        String hello = "hello";

        mvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string(hello));
    }

    @Test
    public void returnHello2() throws  Exception {
        String hello2 = "hello2";

        mvc.perform(get("/hello2?id=1&password=3")).andExpect(status().isOk()).andExpect(content().string(hello2));
    }

    @Test
    public void returnHelloDto() throws  Exception {
        String name = "Hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto").param("name",name).param("amount",String.valueOf(1000)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
