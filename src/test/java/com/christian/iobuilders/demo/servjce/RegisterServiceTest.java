package com.christian.iobuilders.demo.servjce;

import com.christian.iobuilders.demo.pojos.User;
import com.christian.iobuilders.demo.service.RegisterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegisterServiceTest {

    @Autowired
    private RegisterService registerService;

   // @MockBean
    //private Repository repository;

    @Test
    public void test_regServiceInits(){
        assertThat(registerService).isNotNull();
    }
/*
    @Test
    public void test_repositoryInits(){
        assertThat(repository).isNotNull();
    }
*/
    @Test
    public void whenUserRegistered_thenCredentialsAreGenerated(){
        Object result = registerService.register(mockUser());
        assertThat((Map)result).containsKeys("key-pair");
    }

    @Test
    public void whenUserInputIsWrong_thenErrorIsReturned(){

    }




    private User mockUser(){
        return new User("test","test", "test@");
    }
}
