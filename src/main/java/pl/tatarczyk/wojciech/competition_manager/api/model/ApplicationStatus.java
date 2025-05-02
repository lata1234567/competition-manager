package pl.tatarczyk.wojciech.competition_manager.api.model;

import jakarta.persistence.Entity;

public enum ApplicationStatus {
    SUBMITTED("Zgłoszony"),
    IN_PROGRESS("Sprawdzany");

    private String name;

    ApplicationStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
