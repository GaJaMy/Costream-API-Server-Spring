package com.gajamy.cotream.application.service.user;

import com.gajamy.cotream.adapter.out.persistence.user.UserPersistenceAdapter;
import com.gajamy.cotream.application.dto.user.request.CreateUserRequest;
import com.gajamy.cotream.application.port.in.user.CreateUserUseCase;
import com.gajamy.cotream.domain.user.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserService implements CreateUserUseCase {
    private final UserPersistenceAdapter userPersistenceAdapter;

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
