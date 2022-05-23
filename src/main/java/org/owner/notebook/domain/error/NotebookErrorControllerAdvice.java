package org.owner.notebook.domain.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NotebookErrorControllerAdvice
{
    @ExceptionHandler(value = ServerError.class)
    public ResponseEntity<ServerError> serverException(ServerError serverError) {
        return new ResponseEntity<>(serverError, serverError.getHttpStatus());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ServerError> serverException(Exception exception) {
        ServerError serverError = new ServerError(exception);
        return new ResponseEntity<>(serverError, serverError.getHttpStatus());
    }
}
