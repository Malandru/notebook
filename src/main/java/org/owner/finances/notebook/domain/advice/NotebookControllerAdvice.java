package org.owner.finances.notebook.domain.advice;

import org.owner.finances.notebook.domain.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NotebookControllerAdvice
{
    @Autowired
    private AdviceProperties adviceProperties;


    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ServerAdvice> notFoundException(NotFoundException exception) {
        exception.printStackTrace();
        ServerAdvice serverAdvice = new ServerAdvice(
                adviceProperties.getNotFoundMessage(),
                exception.getClassDetails(),
                exception.getTargetID(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(serverAdvice, serverAdvice.getHttpStatus());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ServerAdvice> serverException(Exception exception) {
        exception.printStackTrace();
        ServerAdvice serverAdvice = new ServerAdvice(exception);
        return new ResponseEntity<>(serverAdvice, serverAdvice.getHttpStatus());
    }
}
