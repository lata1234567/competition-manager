package pl.tatarczyk.wojciech.competition_manager.api.exception;

public class CompetitionNotFoundException extends Exception {
    public CompetitionNotFoundException(String message) {
        super(message);
    }

    public CompetitionNotFoundException (String message, Throwable cause){
        super(message, cause);
    }
}
