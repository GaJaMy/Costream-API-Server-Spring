package com.gajamy.cotream.application.port.in.auth;

import com.gajamy.cotream.application.dto.user.request.SignInRequest;

public interface SignInUseCase {
    void signIn(SignInRequest request);
}
