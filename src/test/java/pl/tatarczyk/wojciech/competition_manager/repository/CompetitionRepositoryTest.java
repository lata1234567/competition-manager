package pl.tatarczyk.wojciech.competition_manager.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.tatarczyk.wojciech.competition_manager.repository.entity.CompetitionEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompetitionRepositoryTest {

    @Autowired
    private CompetitionRepository competitionRepository;

    @Test
    void given_when_then(){
        //Given
        CompetitionEntity competitionEntity = new CompetitionEntity();
        //When
        CompetitionEntity savedCompetitionEntity = competitionRepository.save(competitionEntity);
        //Then
        assertNotNull(savedCompetitionEntity, "savedCompetitionEntity is NULL");
    }
}