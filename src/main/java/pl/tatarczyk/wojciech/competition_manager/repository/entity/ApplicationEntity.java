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

    public ApplicationEntity() {
    }

    public ApplicationEntity(Long id, CompetitionEntity competition, UserEntity submitted, UserEntity submittedBy, UserEntity createdBy, LocalDate createdDate) {
        this.id = id;
        this.competition = competition;
        this.submitted = submitted;
        this.submittedBy = submittedBy;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CompetitionEntity getCompetition() {
        return competition;
    }

    public void setCompetition(CompetitionEntity competition) {
        this.competition = competition;
    }

    public UserEntity getSubmitted() {
        return submitted;
    }

    public void setSubmitted(UserEntity submitted) {
        this.submitted = submitted;
    }

    public UserEntity getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(UserEntity submittedBy) {
        this.submittedBy = submittedBy;
    }

    public UserEntity getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserEntity createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "ApplicationEntity{" +
                "id=" + id +
                ", competition=" + competition +
                ", submitted=" + submitted +
                ", submittedBy=" + submittedBy +
                ", createdBy=" + createdBy +
                ", createdDate=" + createdDate +
                '}';
    }
}
