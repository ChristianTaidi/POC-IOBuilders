package com.christian.iobuilders.demo.controller;

import com.christian.iobuilders.demo.controller.impl.RegisterRequestControllerImpl;
import com.christian.iobuilders.demo.pojos.User;
import com.christian.iobuilders.demo.service.RegisterService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@WebMvcTest(RegisterRequestControllerImpl.class)
public class RegisterRequestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private RegisterService registerService;

    @Test
    public void whenUserSent_thenReturns200AndIdIsAssigned()throws Exception{
        User testUser = mockUser();
        mockMvc.perform(post("/register")
                .contentType(APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(testUser))
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)));
    }


    User mockUser(){
        return new User("12345678A","test@mail.mail","test");
    }
}
