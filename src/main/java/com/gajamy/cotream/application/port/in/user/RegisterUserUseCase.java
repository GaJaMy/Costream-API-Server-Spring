package com.gajamy.cotream.application.port.in.user;

import com.gajamy.cotream.application.dto.user.request.SignUpRequest;

public interface RegisterUserUseCase {
    void registerUser(SignUpRequest request);
}
