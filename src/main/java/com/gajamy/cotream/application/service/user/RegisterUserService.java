package com.gajamy.cotream.application.service.user;

import com.gajamy.cotream.adapter.out.persistence.user.UserPersistenceAdapter;
import com.gajamy.cotream.application.dto.user.request.SignInRequest;
import com.gajamy.cotream.application.port.in.user.RegisterUserUseCase;
import com.gajamy.cotream.infrastructure.redis.service.TokenService;
import com.gajamy.cotream.infrastructure.security.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterUserService implements RegisterUserUseCase {
    @Override
    public void registerUser() {

    }
}
