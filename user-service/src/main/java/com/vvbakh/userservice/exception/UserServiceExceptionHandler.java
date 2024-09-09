package com.vvbakh.userservice.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class UserServiceExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFoundException(NotFoundException e) {
        Map<String, String> error = new HashMap<>();

        error.put("error", e.getLocalizedMessage());
        log.error(e.getLocalizedMessage());
        return new ErrorResponse(error, HttpStatus.NOT_FOUND.value(), LocalDateTime.now());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleAllException(Exception e) {
        Map<String, String> errors = new HashMap<>();

        errors.put("errorMessage", e.getLocalizedMessage());
        errors.put("stackTrace", getStackTraceAsString(e));
        log.error(e.getLocalizedMessage());
        return new ErrorResponse(errors, HttpStatus.INTERNAL_SERVER_ERROR.value(), LocalDateTime.now());

    }

    private String getStackTraceAsString(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.toString();
    }
}
