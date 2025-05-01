package pl.tatarczyk.wojciech.competition_manager.service.mapper;

import org.junit.jupiter.api.Test;
import pl.tatarczyk.wojciech.competition_manager.api.model.ApplicationStatus;
import pl.tatarczyk.wojciech.competition_manager.repository.entity.ApplicationEntity;
import pl.tatarczyk.wojciech.competition_manager.repository.entity.CompetitionEntity;
import pl.tatarczyk.wojciech.competition_manager.repository.entity.UserEntity;
import pl.tatarczyk.wojciech.competition_manager.web.model.ApplicationModel;
import pl.tatarczyk.wojciech.competition_manager.web.model.CompetitionModel;
import pl.tatarczyk.wojciech.competition_manager.web.model.UserModel;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationMapperTest {

    private static final Long APPLICATION_ID = 2L;
    private static final LocalDate APPLICATION_CREATED_DATE = LocalDate.of(24, Month.APRIL,1);
    private static final ApplicationStatus APPLICATION_STATUS = ApplicationStatus.SUBMITTED;

    @Test
    void from() {
        //Given
        ApplicationMapper applicationMapper = new ApplicationMapper();
        ApplicationModel applicationModel = new ApplicationModel();

        applicationModel.setId(APPLICATION_ID);
        applicationModel.setCompetition(new CompetitionModel());
        applicationModel.setSubmitted(new UserModel());
        applicationModel.setSubmittedBy(new UserModel());
        applicationModel.setCreatedBy(new UserModel());
        applicationModel.setCreatedDate(APPLICATION_CREATED_DATE);
        applicationModel.setStatus(APPLICATION_STATUS);

        //When
        ApplicationEntity applicationEntity = applicationMapper.from(applicationModel);
        //Then
        assertAll(
                ()->assertNotNull(applicationEntity,"applicationEntity is NULL"),
                ()->assertEquals(APPLICATION_ID,applicationEntity.getId(),"applicationEntity ID is not equals"),
                ()->assertNotNull(applicationEntity.getCompetition(),"applicationEntity COMPETITION is NULL"),
                ()->assertNotNull(applicationEntity.getSubmitted(),"applicationEntity SUBMITTED is NULL"),
                ()->assertNotNull(applicationEntity.getSubmittedBy(),"applicationEntity SUBMITTED_BY is NULL"),
                ()->assertNotNull(applicationEntity.getCreatedBy(),"applicationEntity CREATED_BY is NULL"),
                ()->assertEquals(APPLICATION_CREATED_DATE, applicationEntity.getCreatedDate(),"applicationEntity APPLICATION_CREATED_DATE is not equals"),
                ()->assertEquals(APPLICATION_STATUS,applicationEntity.getStatus(),"applicationEntity STATUS is not equals")
        );
    }

    @Test
    void fromModels() {
        //Given
        ApplicationMapper applicationMapper = new ApplicationMapper();
        List<ApplicationModel> applicationModels = new ArrayList<>();
        applicationModels.add(new ApplicationModel());
        applicationModels.add(new ApplicationModel());
        applicationModels.add(new ApplicationModel());
        //When
        List<ApplicationEntity> applicationEntities = applicationMapper.fromModels(applicationModels);
        //Then
        assertAll(
                ()->assertNotNull(applicationEntities,"applicationEntities is NULL"),
                ()->assertEquals(applicationModels.size(),applicationEntities.size(),"models and entities SIZE is not equals")
        );
    }
}