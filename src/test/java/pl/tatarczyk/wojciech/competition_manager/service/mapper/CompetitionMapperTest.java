package pl.tatarczyk.wojciech.competition_manager.service.mapper;

import org.junit.jupiter.api.Test;
import pl.tatarczyk.wojciech.competition_manager.api.model.CompetitionStage;
import pl.tatarczyk.wojciech.competition_manager.api.model.CompetitionSubject;
import pl.tatarczyk.wojciech.competition_manager.repository.entity.CompetitionEntity;
import pl.tatarczyk.wojciech.competition_manager.web.model.CompetitionModel;
import pl.tatarczyk.wojciech.competition_manager.web.model.UserModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompetitionMapperTest {

    private static final Long COMPETITION_ID = 2L;
    private static final String COMPETITION_NAME = "tak";
    private static final CompetitionSubject COMPETITION_SUBJECT = CompetitionSubject.PHYSIC;
    private static final CompetitionStage COMPETITION_STAGE = CompetitionStage.SCHOOL_STAGE;
    private static final UserModel COMPETITION_CREATED_BY = new UserModel();
    private static final LocalDate COMPETITION_CREATED_DATE = LocalDate.of(1,2,3);
    private static final UserModel COMPETITION_MODIFY_BY = new UserModel();
    private static final LocalDate COMPETITION_MODIFY_DATE = LocalDate.of(3,5,1);

    @Test
    void form() {
        //Given
        CompetitionMapper competitionMapper = new CompetitionMapper();
        CompetitionModel competitionModel = new CompetitionModel();

        competitionModel.setId(COMPETITION_ID);
        competitionModel.setName(COMPETITION_NAME);
        competitionModel.setSubject(COMPETITION_SUBJECT);
        competitionModel.setStage(COMPETITION_STAGE);
        competitionModel.setCreatedBy(COMPETITION_CREATED_BY);
        competitionModel.setCreatedDate(COMPETITION_CREATED_DATE);
        competitionModel.setModifyBy(COMPETITION_MODIFY_BY);
        competitionModel.setModifyDate(COMPETITION_MODIFY_DATE);

        //When
        CompetitionEntity competitionEntity = competitionMapper.from(competitionModel);
        //Then
        assertAll(
                ()->assertNotNull(competitionEntity,"competitionEntity is NULL"),
                () -> assertEquals(COMPETITION_ID, competitionEntity.getId(),"competitionEntity ID is not equals"),
                () -> assertEquals(COMPETITION_NAME, competitionEntity.getName(), "competitionEntity NAME is not equals"),
                () -> assertEquals(COMPETITION_SUBJECT, competitionEntity.getSubject(),"competitionEntity SUBJECT is not equals"),
                () -> assertEquals(COMPETITION_STAGE, competitionEntity.getStage(), "competitionEntity STAGE is not equals"),
                () -> assertNotNull(competitionEntity.getCreatedBy(),"competitionEntity CREATED_BY is NULL"),
                () -> assertEquals(COMPETITION_CREATED_DATE,competitionEntity.getCreatedDate(),"competitionEntity "),
                () -> assertNotNull(competitionEntity.getModifyBy(),"competitionEntity MODIFY_BY od NULL"),
                () -> assertEquals(COMPETITION_MODIFY_DATE, competitionEntity.getModifyDate(),"competitionEntity MODIFY_DATE is not equals")
                );

    }

    @Test
    void fromEntities() {
        //Given
        CompetitionMapper competitionMapper = new CompetitionMapper();
        List<CompetitionEntity> competitionEntities = new ArrayList<>();
        competitionEntities.add(new CompetitionEntity());
        competitionEntities.add(new CompetitionEntity());
        competitionEntities.add(new CompetitionEntity());
        competitionEntities.add(new CompetitionEntity());
        //When
        List<CompetitionModel> competitionModels = competitionMapper.fromEntities(competitionEntities);
        //Then
        assertAll(
                ()->assertNotNull(competitionModels, "competitionModels is NULL"),
                ()->assertEquals(competitionEntities.size(),competitionModels.size(),"entities and models SIZE is not equals")
        );

    }
}