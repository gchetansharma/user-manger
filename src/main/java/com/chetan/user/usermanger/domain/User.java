package com.chetan.user.usermanger.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder
public class User {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String email;

}
