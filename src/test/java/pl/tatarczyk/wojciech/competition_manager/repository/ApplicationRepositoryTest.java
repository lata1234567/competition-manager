package pl.tatarczyk.wojciech.competition_manager.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.tatarczyk.wojciech.competition_manager.repository.entity.ApplicationEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApplicationRepositoryTest {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Test
    void given_when_then(){
        //Given
        ApplicationEntity applicationEntity = new ApplicationEntity();
        //When
        ApplicationEntity savedApplicationEntity = applicationRepository.save(applicationEntity);
        //Then
        assertNotNull(savedApplicationEntity,"savedApplicationEntity is NULL");
    }
}