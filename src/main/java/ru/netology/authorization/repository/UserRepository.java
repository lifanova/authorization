package ru.netology.authorization.repository;

import org.springframework.stereotype.Repository;
import ru.netology.authorization.model.Authorities;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private final Map<List<String>, List<Authorities>> userAuthoritiesList = new ConcurrentHashMap<>();

        public List<Authorities> getUserAuthorities(String user, String password) {

        for (Map.Entry<List<String>, List<Authorities>> userAuthoritiesEntry : userAuthoritiesList.entrySet()) {

            if ((userAuthoritiesEntry.getKey().contains(user)) && (userAuthoritiesEntry.getKey().contains(password))) {
                return userAuthoritiesEntry.getValue();
            }
        }

        return Collections.emptyList();
    }
}
