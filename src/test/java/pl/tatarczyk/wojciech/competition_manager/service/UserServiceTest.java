package pl.tatarczyk.wojciech.competition_manager.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.tatarczyk.wojciech.competition_manager.web.model.UserModel;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void list() {
        //Given

        //When
        List<UserModel> userModels = userService.list();
        //Then
        System.out.println(userModels);
    }

    @Test
    void create() {
        //Given
        UserModel userModel = new UserModel();
        //When
        UserModel savedUserModel = userService.create(userModel);
        //Then
        assertNotNull(savedUserModel,"savedUserModel is NULL");
    }

    @Test
    void update() {
        //Given
        UserModel userModel = new UserModel();
        //When
        UserModel updateUserModel = userService.update(userModel);
        //Then
        assertNotNull(updateUserModel,"updateUserModel is NULL");
    }
}