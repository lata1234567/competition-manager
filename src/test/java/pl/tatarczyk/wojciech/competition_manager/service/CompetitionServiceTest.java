package pl.tatarczyk.wojciech.competition_manager.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.tatarczyk.wojciech.competition_manager.web.model.CompetitionModel;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompetitionServiceTest {

    @Autowired
    private CompetitionService competitionService;

    @Test
    void list() {
        //Given

        //When
        List<CompetitionModel> competitionModels = competitionService.list();
        //Then
        System.out.println(competitionModels);
    }

    @Test
    void create() {
        //Given
        CompetitionModel competitionModel = new CompetitionModel();
        //When
        CompetitionModel savedCompetitionModel = competitionService.create(competitionModel);
        //Then
        assertNotNull(savedCompetitionModel,"savedCompetitionModel is NULL");
    }

    @Test
    void update() {
        //Given
        CompetitionModel competitionModel = new CompetitionModel();
        //When
        CompetitionModel updateCompetitionModel = competitionService.update(competitionModel);
        //Then
        assertNotNull(updateCompetitionModel,"updateCompetitionModel is NULL");
    }
}