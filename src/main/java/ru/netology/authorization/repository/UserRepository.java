package ru.netology.authorization.repository;

import org.springframework.stereotype.Repository;
import ru.netology.authorization.model.Authorities;
import ru.netology.authorization.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class UserRepository {

    public List<Authorities> getUserAuthorities(String login, String password) {


        for (User user : getUsers()) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user.getAuthorities();
            }
        }

        return Collections.emptyList();
    }

    private List<User> getUsers() {
        List<User> users = new ArrayList<>();

        List<Authorities> authorities = new ArrayList<>();
        authorities.add(Authorities.READ);
        authorities.add(Authorities.WRITE);

        users.add(new User("test1", "Qwerty1", authorities));

        authorities = new ArrayList<>();
        authorities.add(Authorities.READ);

        users.add(new User("test2", "Qwerty2", authorities));

        return users;
    }

}
