package com.chetan.user.usermanger.controller.dto;

import com.chetan.user.usermanger.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;


@Builder
@Value
@AllArgsConstructor
public class UserRequest {

    private String firstName;
    private String lastName;
    private String email;

    public User toUser() {
        return User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .build();
    }
}
