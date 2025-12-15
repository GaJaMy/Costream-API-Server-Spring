package com.gajamy.cotream.application.port.out.user;

import com.gajamy.cotream.domain.user.entity.Users;

public interface SaveUserPort {
    Users save(Users users);
}
