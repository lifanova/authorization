package ru.netology.authorization.repository;

import org.springframework.stereotype.Repository;
import ru.netology.authorization.model.Authorities;
import ru.netology.authorization.model.User;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class UserRepository {
    List<User> users = Arrays.asList(
            new User("test1", "Qwerty1", Arrays.asList(Authorities.READ, Authorities.WRITE)),
            new User("test2", "Qwerty2", Arrays.asList(Authorities.READ, Authorities.WRITE, Authorities.DELETE)));


    public List<Authorities> getUserAuthorities(String login, String password) {
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user.getAuthorities();
            }
        }

        return Collections.emptyList();
    }



}
