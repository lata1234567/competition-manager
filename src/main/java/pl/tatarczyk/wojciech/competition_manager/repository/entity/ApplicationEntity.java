package pl.tatarczyk.wojciech.competition_manager.repository.entity;

import jakarta.persistence.*;
import pl.tatarczyk.wojciech.competition_manager.api.model.ApplicationStatus;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class ApplicationEntity implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private CompetitionEntity competition;
    @ManyToOne
    private UserEntity submitted;
    @ManyToOne
    private UserEntity submittedBy;


    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;

    @ManyToOne
    private UserEntity createdBy;
    private LocalDate createdDate;

    public ApplicationEntity() {
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

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "ApplicationEntity{" +
                "id=" + id +
                ", competition=" + competition +
                ", submitted=" + submitted +
                ", submittedBy=" + submittedBy +
                ", status=" + status +
                ", createdBy=" + createdBy +
                ", createdDate=" + createdDate +
                '}';
    }
}
