package com.gajamy.ChzzkHub.application.service.user;

import com.gajamy.ChzzkHub.application.dto.user.request.CreateUserRequest;
import com.gajamy.ChzzkHub.application.port.in.user.CreateUserUseCase;
import com.gajamy.ChzzkHub.domain.user.entity.Users;
import com.gajamy.ChzzkHub.infrastructure.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserService implements CreateUserUseCase {
    private final UserRepository userRepository;

    public void createUser(CreateUserRequest request){
        // todo 치지직 인증 API 호출
        String id = "스트리머 아이디";
        String profile = "테스트 프로필";
        int followers = 100;
        Users user = Users.builder()
                .id(id)
                .profile(profile)
                .followers(followers)
                .build();
    }
}
