package pl.tatarczyk.wojciech.competition_manager.web.model;

import lombok.Data;
import pl.tatarczyk.wojciech.competition_manager.repository.entity.CompetitionEntity;
import pl.tatarczyk.wojciech.competition_manager.repository.entity.UserEntity;

import java.time.LocalDate;

@Data
public class ApplicationModel {
    private Long id;

    private CompetitionEntity competition;
    private UserEntity submitted;
    private UserEntity submittedBy;

    private UserEntity createdBy;
    private LocalDate createdDate;
}
