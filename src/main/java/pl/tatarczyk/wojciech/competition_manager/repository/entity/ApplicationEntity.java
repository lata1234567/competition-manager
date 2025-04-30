package pl.tatarczyk.wojciech.competition_manager.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class ApplicationEntity {

    @Id
    @GeneratedValue
    private Long id;

    private CompetitionEntity competition;
    private UserEntity submitted;
    private UserEntity submittedBy;

    private UserEntity createdBy;
    private LocalDate createdDate;
}
