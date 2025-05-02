package pl.tatarczyk.wojciech.competition_manager.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.tatarczyk.wojciech.competition_manager.repository.entity.RoleEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    void given_when_then(){
        //Given
        RoleEntity roleEntity = new RoleEntity();
        //When
        RoleEntity savedRoleEntity = roleRepository.save(roleEntity);
        //Then
        assertNotNull(savedRoleEntity,"savedRoleEntity is NULL");
    }
}