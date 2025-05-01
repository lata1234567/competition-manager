package pl.tatarczyk.wojciech.competition_manager.web.model;

import java.time.LocalDate;

public class ApplicationModel {
    private Long id;

    private CompetitionModel competition;
    private UserModel submitted;
    private UserModel submittedBy;

    private UserModel createdBy;
    private LocalDate createdDate;

    public ApplicationModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CompetitionModel getCompetition() {
        return competition;
    }

    public void setCompetition(CompetitionModel competition) {
        this.competition = competition;
    }

    public UserModel getSubmitted() {
        return submitted;
    }

    public void setSubmitted(UserModel submitted) {
        this.submitted = submitted;
    }

    public UserModel getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(UserModel submittedBy) {
        this.submittedBy = submittedBy;
    }

    public UserModel getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserModel createdBy) {
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
        return "ApplicationModel{" +
                "id=" + id +
                ", competition=" + competition +
                ", submitted=" + submitted +
                ", submittedBy=" + submittedBy +
                ", createdBy=" + createdBy +
                ", createdDate=" + createdDate +
                '}';
    }
}
