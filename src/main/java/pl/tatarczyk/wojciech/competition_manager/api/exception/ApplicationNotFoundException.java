package pl.tatarczyk.wojciech.competition_manager.api.exception;

public class ApplicationNotFoundException extends Exception {
    public ApplicationNotFoundException(String message) {
        super(message);
    }

    public ApplicationNotFoundException (String message, Throwable cause){
        super(message, cause);
    }
}
