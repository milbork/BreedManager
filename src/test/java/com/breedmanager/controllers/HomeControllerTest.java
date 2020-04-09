package com.breedmanager.controllers;

import com.breedmanager.Application;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest( classes = Application.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
class HomeControllerTest {

    @Autowired
    HomeController homeController;

    @Autowired
    MockMvc mockMvc;

    @Test
    void start() throws Exception {

        mockMvc.perform(post("/")
                .contentType("application/json"))
                .andExpect(status().isForbidden());


    }
}