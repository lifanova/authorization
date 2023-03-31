package ru.netology.authorization.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.authorization.exception.InvalidCredentials;
import ru.netology.authorization.exception.UnauthorizedUser;
import ru.netology.authorization.model.Authorities;
import ru.netology.authorization.service.AuthorizationService;

import java.util.List;

@RestController
@RequestMapping("/")
public class AuthorizationController {
    private AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

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
