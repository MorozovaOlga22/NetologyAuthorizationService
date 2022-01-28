package ru.netology.authorizationservice.repository;

import org.springframework.stereotype.Repository;
import ru.netology.authorizationservice.enums.Authorities;

import java.util.*;

import static ru.netology.authorizationservice.enums.Authorities.*;

@Repository
public class UserRepository {
    private final Map<String, UserData> users = getUsersMap();

    public List<Authorities> getUserAuthorities(String user, String password) {
        final UserData userData = users.get(user);
        return (userData == null || !userData.password.equals(password)) ? Collections.emptyList() : userData.authorities;
    }

    private Map<String, UserData> getUsersMap() {
        final Map<String, UserData> users = new HashMap<>();
        users.put("Ivanov", new UserData("123", Arrays.asList(READ, WRITE)));
        users.put("Sidorova", new UserData("567", Arrays.asList(READ, WRITE, DELETE)));
        users.put("Petrov", new UserData("password", List.of(READ)));
        return users;
    }

    private static class UserData {
        private final String password;
        private final List<Authorities> authorities;

        public UserData(String password, List<Authorities> authorities) {
            this.password = password;
            this.authorities = authorities;
        }
    }
}