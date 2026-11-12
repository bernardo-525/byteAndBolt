package com.byteandbolt.byteAndBolt.exception;

import com.byteandbolt.byteAndBolt.DTOs.BabErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BabGlobalExceptionHandler {
    @ExceptionHandler(BabException.class)
    public ResponseEntity<BabErrorDTO> handleException(BabException exception) {
        final BabErrorMessage errorMessage = exception.getErrorMessage();
        final HttpStatus status = BabErrorMessage.getHttpStatus(errorMessage);
        BabErrorDTO body = new BabErrorDTO(errorMessage, errorMessage.getMessage());
        return ResponseEntity.status(status).body(body);
    }

}
