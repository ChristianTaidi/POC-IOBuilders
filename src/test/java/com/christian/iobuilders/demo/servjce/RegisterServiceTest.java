package com.christian.iobuilders.demo.servjce;

import com.christian.iobuilders.demo.pojos.User;
import com.christian.iobuilders.demo.service.RegisterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionSystemException;

import javax.validation.ConstraintViolationException;
import java.security.InvalidParameterException;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegisterServiceTest {

    @Autowired
    private RegisterService registerService;

    @Test
    public void test_regServiceInits(){
        assertThat(registerService).isNotNull();
    }

    @Test
    public void whenUserRegistered_thenIDIsGenerated(){

        User user = registerService.register(mockUser());
        assertThat(user).extracting(User::getId).isNotEmpty();
    }

    @Test
    public void whenUserIsNull_thenErrorIsReturned(){

        User user = null;
        assertThatThrownBy(()->{
            registerService.register(user);

        }).isInstanceOf(NullPointerException.class)
                .hasMessageContaining("Null User");

    }

    @Test
    public void whenUserEmailIsWrong_thenErrorIsReturned(){

        User user = mockUser();
        user.setEmail("asdf");
        assertThatThrownBy(()->{
            registerService.register(user);

        }).isInstanceOf(InvalidParameterException.class)
        .hasMessageContaining("Email is invalid");

    }

    @Test
    public void whenUserDNIIsWrong_thenErrorIsReturned(){

        User user = mockUser();
        user.setDni("asdf");
        assertThatThrownBy(()->{
            registerService.register(user);

        }).isInstanceOf(InvalidParameterException.class)
                .hasMessageContaining("DNI length is not correct");

    }




    private User mockUser(){
        return new User("12345678A","test", "test@test.com","password");

    }
}
