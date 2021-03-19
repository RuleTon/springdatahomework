package ru.gb.springdatahomework.exceptions;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ExceprionContollerAdvice {

    @ExceptionHandler
    public ResponseEntity<?> handlerResourceNotFoundException (ResourceNotFound e) {
        log.error(e.getMessage());
        ShopError err = new ShopError(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity <?> handleNoAuthException(NpAuthException e) {
        log.error(e.getMessage());
        ShopError err = new ShopError(HttpStatus.UNAUTHORIZED.value(), e.getMessage());
        return new ResponseEntity<>(err, HttpStatus.UNAUTHORIZED);

    }
 }
