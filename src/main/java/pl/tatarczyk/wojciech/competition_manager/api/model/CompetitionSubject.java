package pl.tatarczyk.wojciech.competition_manager.api.model;

public enum CompetitionSubject {
    MATH("Matematyka"),
    PHYSIC("Fizyka");

    private String name;

    CompetitionSubject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
