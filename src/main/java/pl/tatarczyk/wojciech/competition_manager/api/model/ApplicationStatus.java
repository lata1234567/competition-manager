package pl.tatarczyk.wojciech.competition_manager.api.model;

public enum ApplicationStatus {
    SUBMITTED("Zgłoszony");

    private String name;

    ApplicationStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
