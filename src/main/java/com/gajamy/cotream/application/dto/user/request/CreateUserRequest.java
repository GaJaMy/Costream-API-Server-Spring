package com.gajamy.cotream.application.dto.user.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateUserRequest {
    private String id;
    private String profile;
    private int followers;

}
