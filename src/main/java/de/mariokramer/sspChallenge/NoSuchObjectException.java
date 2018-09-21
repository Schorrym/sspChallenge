package de.mariokramer.sspChallenge;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoSuchObjectException extends RuntimeException {
    private static final long serialVersionUID = -1469903817218715717L;

    public NoSuchObjectException() {
        super();
    }
    public NoSuchObjectException(String message, Throwable cause) {
        super(message, cause);
    }
    public NoSuchObjectException(String message) {
        super(message);
    }
    public NoSuchObjectException(Throwable cause) {
        super(cause);
    }
}
