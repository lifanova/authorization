package ru.netology.authorization.repository;

import org.springframework.stereotype.Repository;
import ru.netology.authorization.model.Authorities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {

    public List<Authorities> getUserAuthorities(String user, String password) {

        for (Map.Entry<String, List<Authorities>> userAuthoritiesEntry : getUserAuthoritiesMap().entrySet()) {

            if ((userAuthoritiesEntry.getKey().contains(user)) && (userAuthoritiesEntry.getKey().contains(password))) {
                return userAuthoritiesEntry.getValue();
            }
        }

        return Collections.emptyList();
    }

    private Map<String, List<Authorities>> getUserAuthoritiesMap() {
        Map<String, List<Authorities>> userAuthoritiesMap = new ConcurrentHashMap<>();
        String firstKey = "test1" + "Qwerty1";
        List<Authorities> authorities = new ArrayList<>();
        authorities.add(Authorities.READ);
        authorities.add(Authorities.WRITE);
        userAuthoritiesMap.put(firstKey, authorities);

        return userAuthoritiesMap;
    }
}
