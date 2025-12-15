package com.gajamy.cotream.adapter.out.persistence.user;

import com.gajamy.cotream.application.port.out.user.DeleteUserPort;
import com.gajamy.cotream.application.port.out.user.LoadUserPort;
import com.gajamy.cotream.application.port.out.user.SaveUserPort;
import com.gajamy.cotream.domain.user.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserPersistenceAdapter implements SaveUserPort, LoadUserPort, DeleteUserPort {
    private final UserJpaRepository userJpaRepository;

    @Override
    public void deleteById(String id) {
        userJpaRepository.deleteById(id);
    }

    @Override
    public Optional<Users> findById(String id) {
        return userJpaRepository.findById(id);
    }

    @Override
    public boolean existsById(String id) {
        return userJpaRepository.existsById(id);
    }

    @Override
    public Users save(Users users) {
        return userJpaRepository.save(users);
    }
}
