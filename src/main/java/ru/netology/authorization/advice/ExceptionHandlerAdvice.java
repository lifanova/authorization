package ru.netology.authorization.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.authorization.exception.InvalidCredentials;
import ru.netology.authorization.exception.UnauthorizedUser;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(InvalidCredentials.class)
    ResponseEntity<String> handle(InvalidCredentials e) {
        return new ResponseEntity<>("Error 400: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    ResponseEntity<String> handle(UnauthorizedUser e) {
        System.out.println("Error 401: " + e.getMessage());
        return new ResponseEntity<>("Error 401: " + e.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
