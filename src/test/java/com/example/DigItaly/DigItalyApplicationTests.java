package com.example.DigItaly;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DigItalyApplicationTests {

    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    void contextLoads() {
    }
    @Test
    public void testGetProduct() throws Exception {
        mvc.perform(
                        MockMvcRequestBuilders.get("/")
                )
                .andExpect(status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.content().string(containsString("Parmigiano Reggiano")));

    }

}
