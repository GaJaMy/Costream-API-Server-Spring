package com.gajamy.cotream.application.service.user;

import com.gajamy.cotream.adapter.out.persistence.user.UserPersistenceAdapter;
import com.gajamy.cotream.application.dto.user.request.RegisterUserRequest;
import com.gajamy.cotream.application.port.in.user.RegisterUserUseCase;
import com.gajamy.cotream.domain.user.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterUserService implements RegisterUserUseCase {
    private final UserPersistenceAdapter userPersistenceAdapter;

    @Override
    public void registerUser(RegisterUserRequest request) {

    }
}
