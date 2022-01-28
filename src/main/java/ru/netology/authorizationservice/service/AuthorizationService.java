package ru.netology.authorizationservice.service;

import org.springframework.stereotype.Service;
import ru.netology.authorizationservice.dto.User;
import ru.netology.authorizationservice.enums.Authorities;
import ru.netology.authorizationservice.exceptions.UnauthorizedUser;
import ru.netology.authorizationservice.repository.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User user) {
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user.getUser());
        }
        return userAuthorities;
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}