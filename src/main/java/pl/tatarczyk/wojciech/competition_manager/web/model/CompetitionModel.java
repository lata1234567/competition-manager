package pl.tatarczyk.wojciech.competition_manager.web.model;

import pl.tatarczyk.wojciech.competition_manager.api.model.CompetitionStage;
import pl.tatarczyk.wojciech.competition_manager.api.model.CompetitionSubject;

import java.time.LocalDate;

public class CompetitionModel {
    private Long id;
    private String name;
    private CompetitionSubject subject;
    private CompetitionStage stage;

    private LocalDate deadline;

    private UserModel createdBy;
    private LocalDate createdDate;

    private UserModel modifyBy;
    private LocalDate modifyDate;

    public CompetitionModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CompetitionSubject getSubject() {
        return subject;
    }

    public void setSubject(CompetitionSubject subject) {
        this.subject = subject;
    }

    public CompetitionStage getStage() {
        return stage;
    }

    public void setStage(CompetitionStage stage) {
        this.stage = stage;
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

    public UserModel getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(UserModel modifyBy) {
        this.modifyBy = modifyBy;
    }

    public LocalDate getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDate modifyDate) {
        this.modifyDate = modifyDate;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "CompetitionModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject=" + subject +
                ", stage=" + stage +
                ", deadline=" + deadline +
                ", createdBy=" + createdBy +
                ", createdDate=" + createdDate +
                ", modifyBy=" + modifyBy +
                ", modifyDate=" + modifyDate +
                '}';
    }
}
