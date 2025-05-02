package pl.tatarczyk.wojciech.competition_manager.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.tatarczyk.wojciech.competition_manager.web.model.ApplicationModel;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApplicationServiceTest {

    @Autowired
    private ApplicationService applicationService;

    @Test
    void list() {
        //Given

        //When
        List<ApplicationModel> applicationModels = applicationService.list();
        //Then
        System.out.println(applicationModels);
    }

    @Test
    void create() {
        //Given
        ApplicationModel applicationModel = new ApplicationModel();
        //When
        ApplicationModel savedApplicationModel = applicationService.create(applicationModel);
        //Then
        assertNotNull(savedApplicationModel,"savedApplicationModel is NULL");
    }

    @Test
    void update() {
        //Given
        ApplicationModel applicationModel = new ApplicationModel();
        //When
        ApplicationModel updateApplicationModel = applicationService.update(applicationModel);
        //Then
        assertNotNull(updateApplicationModel,"updateApplicationModel is NULL");
    }
}