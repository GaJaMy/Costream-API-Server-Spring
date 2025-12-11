package com.gajamy.cotream.application.port.in.user;

import com.gajamy.cotream.application.dto.user.request.RegisterUserRequest;

public interface RegisterUserUseCase {
    void registerUser(RegisterUserRequest request);
}
