package com.christian.iobuilders.demo.repository;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

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
/*
    @Before
    public void init(){
        Claim claim = mockClaim();
        claim.setId(1L);
        when(mockRepository.findAll()).thenReturn(Arrays.asList(claim));
        when(mockRepository.findById(1L)).thenReturn(Optional.of(claim));
        when(mockRepository.save(any(Claim.class))).thenReturn(claim);
    }

    @Test
    public void it_should_save_the_claim(){
        Claim claim = mockClaim();
        assertThat(mockRepository.save(claim).getId()).isNotNull();
    }

    @Test
    public void it_should_find_the_claim_by_id(){
        Optional<Claim> claim = mockRepository.findById(1L);
        assertThat(claim.get().getId()).isEqualTo(1L);
    }

    @Test
    public void it_should_return_all_claims_stored(){
        List<Claim> claims = mockRepository.findAll();
        assertThat(claims.contains(Claim.class));
        assertThat(claims).isNotEmpty();
    }

    @Test
    public void it_should_save_data_in_real_repository(){
        Claim claim = mockClaim();
        Assertions.assertNotNull(realRepository.save(claim));
    }

    @Test
    public void it_should_find_by_id_in_real_repository(){
        Claim claim = mockClaim();
        claim = realRepository.save(claim);
        assertThat(realRepository.findById(claim.getId()).get()).isEqualTo(claim);
    }

    private Claim mockClaim(){
        return new Claim("TEST_CLAIM","DEFAULT JSON");
    }
*/
}
