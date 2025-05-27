package pl.tatarczyk.wojciech.competition_manager.repository.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import pl.tatarczyk.wojciech.competition_manager.api.model.CompetitionStage;
import pl.tatarczyk.wojciech.competition_manager.api.model.CompetitionSubject;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class CompetitionEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "competitionSubject")
//    @ManyToOne
    private CompetitionSubject subject;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate deadline;

    @Enumerated(EnumType.STRING)
    @Column(name="competitionStage")
//    @ManyToOne
    private CompetitionStage stage;

    @ManyToOne
    private UserEntity createdBy;
    private LocalDate createdDate;

    @ManyToOne
    private UserEntity modifyBy;
    private LocalDate modifyDate;

    public CompetitionEntity() {
    }

    public CompetitionEntity(Long id, String name, CompetitionSubject subject, LocalDate deadline, CompetitionStage stage, UserEntity createdBy, LocalDate createdDate, UserEntity modifyBy, LocalDate modifyDate) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.deadline = deadline;
        this.stage = stage;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifyBy = modifyBy;
        this.modifyDate = modifyDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public CompetitionSubject getSubject() {
        return subject;
    }

    public void setSubject(CompetitionSubject subject) {
        this.subject = subject;
    }

    public UserEntity getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserEntity createdBy) {
        this.createdBy = createdBy;
    }

    public CompetitionStage getStage() {
        return stage;
    }

    public void setStage(CompetitionStage stage) {
        this.stage = stage;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public UserEntity getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(UserEntity modifyBy) {
        this.modifyBy = modifyBy;
    }

    public LocalDate getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDate modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Override
    public String toString() {
        return "CompetitionEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject=" + subject +
                ", deadline=" + deadline +
                ", stage=" + stage +
                ", createdBy=" + createdBy +
                ", createdDate=" + createdDate +
                ", modifyBy=" + modifyBy +
                ", modifyDate=" + modifyDate +
                '}';
    }
}
