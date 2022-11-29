package novi.nl.Les11BESpringbootmodelhuiswerk.exceptions;

public class RecordNotFoundException extends RuntimeException {
    public RecordNotFoundException() {
        super("Record not found");
    }

    public RecordNotFoundException(String message) {
        super(message);
    }
}
