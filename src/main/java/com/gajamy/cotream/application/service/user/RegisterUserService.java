package com.gajamy.cotream.application.service.user;

import com.gajamy.cotream.application.dto.user.request.SignUpRequest;
import com.gajamy.cotream.application.port.in.user.RegisterUserUseCase;
import com.gajamy.cotream.application.port.out.user.SaveUserPort;
import com.gajamy.cotream.domain.user.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterUserService implements RegisterUserUseCase {
    private final SaveUserPort saveUserPort;

    @Override
    public void registerUser(SignUpRequest request) {
        String id = request.getId();
        String password = request.getPassword();

        Users users = Users.builder()
                .id(id)
                .password(password)
                .build();

        saveUserPort.save(users);
    }
}
