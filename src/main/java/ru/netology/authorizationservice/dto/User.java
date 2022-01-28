package ru.netology.authorizationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@Validated
public class User {
    @NotEmpty
    private final String user;
    @NotEmpty
    private final String password;
}
