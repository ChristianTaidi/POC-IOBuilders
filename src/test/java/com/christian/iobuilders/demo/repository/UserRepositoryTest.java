package com.christian.iobuilders.demo.repository;
import com.christian.iobuilders.demo.pojos.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository realRepository;

    @Bean
    private UserRepository mockRepository(){
        return Mockito.mock(UserRepository.class);
    }

    UserRepository mockRepository = mockRepository();

    @Before
    public void init(){
        User user = mockUser();
        user.setId(1L);
        when(mockRepository.findAll()).thenReturn(Arrays.asList(user));
        when(mockRepository.findById(1L)).thenReturn(Optional.of(user));
        when(mockRepository.save(any(User.class))).thenReturn(user);
    }

    @Test
    public void it_should_save_the_user(){
        User user = mockUser();
        assertThat(mockRepository.save(user).getId()).isNotNull();
    }

    @Test
    public void it_should_find_the_user_by_id(){
        Optional<User> user = mockRepository.findById(1L);
        assertThat(user.get().getId()).isEqualTo(1L);
    }

    @Test
    public void it_should_return_all_users_stored(){
        List<User> users = mockRepository.findAll();
        assertThat(users.contains(User.class));
        assertThat(users).isNotEmpty();
    }

    @Test
    public void it_should_save_data_in_real_repository(){
        User user = mockUser();
        Assertions.assertNotNull(realRepository.save(user));
    }

    @Test
    public void it_should_find_by_dni_in_real_repository(){
        User user = mockUser();
        User dbUser = realRepository.findByDni(user.getDni());
        if(dbUser==null) {
            dbUser = realRepository.save(user);
        }
        assertThat(realRepository.findByDni(dbUser.getDni()).getDni()).isEqualTo(user.getDni());
    }

    @Test
    public void it_should_find_by_id_in_real_repository(){
        User user = mockUser();

        User dbUser = realRepository.findByDni(user.getDni());
        if(dbUser==null) {
            dbUser = realRepository.save(user);
        }
        assertThat(realRepository.findById(dbUser.getId()).get().getDni()).isEqualTo(user.getDni());
    }

    private User mockUser(){
        return new User("12345678A","test", "test@test.com","password");
    }

}
