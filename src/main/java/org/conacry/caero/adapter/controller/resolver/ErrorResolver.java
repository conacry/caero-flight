package org.conacry.caero.adapter.controller.resolver;

import jakarta.servlet.http.HttpServletRequest;
import org.conacry.caero.adapter.controller.response.AlertResponse;
import org.conacry.caero.shared.exception.CodedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ErrorResolver {

    private static final String SYSTEM_ERROR_CODE = "dfe99c9e-001";

    @ExceptionHandler(value = CodedException.class)
    public ResponseEntity<AlertResponse> handleAppExceptions(CodedException ex, HttpServletRequest request) {
        var errResponse = AlertResponse.builder()
                .httpCode(HttpStatus.UNPROCESSABLE_ENTITY.name())
                .path(request.getRequestURI())
                .errorCode(ex.getCode())
                .msg(ex.getMessage())
                .timestamp(Instant.now().toEpochMilli())
                .build();

        return new ResponseEntity<>(errResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<AlertResponse> handleNotReadableExceptions(HttpMessageNotReadableException ex, HttpServletRequest request) {
        var errResponse = AlertResponse.builder()
                .httpCode(HttpStatus.BAD_REQUEST.name())
                .path(request.getRequestURI())
                .errorCode(SYSTEM_ERROR_CODE)
                .msg(ex.getMessage())
                .timestamp(Instant.now().toEpochMilli())
                .build();

        return new ResponseEntity<>(errResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<AlertResponse> handleSystemExceptions(RuntimeException ex, HttpServletRequest request) {
        var errResponse = AlertResponse.builder()
                .httpCode(HttpStatus.INTERNAL_SERVER_ERROR.name())
                .path(request.getRequestURI())
                .errorCode(SYSTEM_ERROR_CODE)
                .msg(ex.getMessage())
                .timestamp(Instant.now().toEpochMilli())
                .build();

        return new ResponseEntity<>(errResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
