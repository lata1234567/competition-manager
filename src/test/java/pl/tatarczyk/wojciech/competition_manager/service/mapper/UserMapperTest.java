package pl.tatarczyk.wojciech.competition_manager.service.mapper;

import org.junit.jupiter.api.Test;
import pl.tatarczyk.wojciech.competition_manager.repository.entity.UserEntity;
import pl.tatarczyk.wojciech.competition_manager.web.model.UserModel;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {

    private static final Long USER_ID = 2L;
    private static final String USER_NAME = "tak";
    private static final String USER_SURNAME = "nie";
    private static final String USER_LOGIN = "admin";
    private static final String USER_PASSWORD = "admin1";
    private static final UserEntity USER_CREATED_BY = new UserEntity();
    private static final LocalDate USER_CREATED_DATE = LocalDate.of(24, Month.JANUARY, 2);
    private static final UserEntity USER_MODIFY_BY = new UserEntity();
    private static final LocalDate USER_MODIFY_DATE = LocalDate.of(25, Month.JANUARY, 2);

    @Test
    void from() {
        //Given
        UserMapper userMapper = new UserMapper();
        UserModel userModel = new UserModel();

        userModel.setId(USER_ID);
        userModel.setName(USER_NAME);
        userModel.setSurname(USER_SURNAME);
        userModel.setLogin(USER_LOGIN);
        userModel.setPassword(USER_PASSWORD);
        userModel.setCreatedBy(USER_CREATED_BY);
        userModel.setCreatedDate(USER_CREATED_DATE);
        userModel.setModifyBy(USER_MODIFY_BY);
        userModel.setModifyDate(USER_MODIFY_DATE);
        //When
        UserEntity userEntity = userMapper.from(userModel);
        //Then
        assertAll(
                () -> assertNotNull(userEntity, "userEntity is NULL"),
                () -> assertEquals(USER_ID, userEntity.getId(), "userEntity ID is not equals"),
                () -> assertEquals(USER_NAME, userEntity.getName(), "userEntity NAME is not equals"),
                () -> assertEquals(USER_SURNAME, userEntity.getSurname(), "userEntity SURNAME is not equals"),
                () -> assertEquals(USER_LOGIN, userEntity.getLogin(), "userEntity LOGIN is not equals"),
                () -> assertEquals(USER_PASSWORD, userEntity.getPassword(),"userEntity PASSWORD is not equals"),
                ()->assertNotNull(userEntity.getCreatedBy(), "userEntity CREATED_BY is NULL"),
                ()->assertEquals(USER_CREATED_DATE, userEntity.getCreatedDate(),"userEntity CREATED_DATE is not equals"),
                ()->assertNotNull(userEntity.getModifyBy(), "userEntity Modify_BY is NULL"),
                ()->assertEquals(USER_MODIFY_DATE, userEntity.getModifyDate(),"userEntity Modify_DATE is not equals")
        );

    }

    @Test
    void fromModels() {
        //Given
        UserMapper userMapper = new UserMapper();
        List<UserEntity> userEntities = new ArrayList<>();
        userEntities.add(new UserEntity());
        userEntities.add(new UserEntity());
        userEntities.add(new UserEntity());
        //When
        List<UserModel> userModels = userMapper.formEntities(userEntities);
        //Then
        assertAll(
                ()->assertNotNull(userModels,"userModels is NULL"),
                ()->assertEquals(userEntities.size(),userModels.size(),"entities and models SIZE is not equals")
        );

    }
}