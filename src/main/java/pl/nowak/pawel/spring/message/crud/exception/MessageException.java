package pl.nowak.pawel.spring.message.crud.exception;

public class MessageException extends Exception {
    public MessageException(String message) {
        super(message);
    }

    protected MessageException(String message, Throwable cause) {
        super(message, cause);
    }
}
