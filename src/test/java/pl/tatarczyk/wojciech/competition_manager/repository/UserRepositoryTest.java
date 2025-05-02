package pl.tatarczyk.wojciech.competition_manager.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.tatarczyk.wojciech.competition_manager.repository.entity.UserEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void given_then_when(){
        //Given
        UserEntity userEntity = new UserEntity();
        //When
        UserEntity savedUserEntity = userRepository.save(userEntity);
        //Then
        assertNotNull(savedUserEntity, "savedUserEntity is NULL");
    }
}