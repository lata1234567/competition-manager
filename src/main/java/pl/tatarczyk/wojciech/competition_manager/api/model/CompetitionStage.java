package pl.tatarczyk.wojciech.competition_manager.api.model;

public enum CompetitionStage {

    SCHOOL_STAGE("Etap szkolny");

    private String name;

    CompetitionStage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
