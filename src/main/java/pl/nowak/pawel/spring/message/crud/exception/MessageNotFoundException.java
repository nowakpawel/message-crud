package pl.nowak.pawel.spring.message.crud.exception;

public class MessageNotFoundException extends MessageException {
    public MessageNotFoundException(String message) {
        super(message);
    }

    protected MessageNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
