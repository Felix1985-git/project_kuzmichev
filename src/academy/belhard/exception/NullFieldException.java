package academy.belhard.exception;

public class NullFieldException extends RuntimeException {

    private static final String ERROR_MESSAGE_NOT_NULL = "Поле [%s] не должно быть null";

    public NullFieldException(String field) {
        super(String.format(ERROR_MESSAGE_NOT_NULL, field));
    }

}
