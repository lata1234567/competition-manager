package pl.tatarczyk.wojciech.competition_manager.web.model;

import lombok.Data;
import pl.tatarczyk.wojciech.competition_manager.api.model.CompetitionStage;
import pl.tatarczyk.wojciech.competition_manager.api.model.CompetitionSubject;
import pl.tatarczyk.wojciech.competition_manager.repository.entity.UserEntity;

import java.time.LocalDate;

@Data
public class CompetitionModel {
    private Long id;
    private String name;
    private CompetitionSubject subject;
    private CompetitionStage stage;

    private UserEntity createdBy;
    private LocalDate createdDate;

    private UserEntity modifyBy;
    private UserEntity modifyDate;
}
