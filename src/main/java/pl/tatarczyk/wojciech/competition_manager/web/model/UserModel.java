package pl.tatarczyk.wojciech.competition_manager.web.model;

import lombok.Data;
import pl.tatarczyk.wojciech.competition_manager.repository.entity.UserEntity;

import java.time.LocalDate;

@Data
public class UserModel {
    private Long id;

    private String name;
    private String surname;
    private String login;
    private String password;

    private UserEntity createdBy;
    private LocalDate createdDate;

    private UserEntity modifyBy;
    private UserEntity modifyDate;
}
