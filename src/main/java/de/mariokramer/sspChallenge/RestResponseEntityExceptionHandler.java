package de.mariokramer.sspChallenge;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoSuchObjectException.class)
    public final ResponseEntity<Object> handleNoSuchObjectException(NoSuchObjectException ex, WebRequest request) {
        String responseBody = "NoSuchObjectException - " + ex.getMessage();
        return handleExceptionInternal(ex, responseBody,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}