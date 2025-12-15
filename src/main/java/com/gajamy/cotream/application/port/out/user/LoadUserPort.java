package com.gajamy.cotream.application.port.out.user;

import com.gajamy.cotream.domain.user.entity.Users;

import java.util.Optional;

public interface LoadUserPort {
    Optional<Users> findById(String id);
    boolean existsById(String id);
}
