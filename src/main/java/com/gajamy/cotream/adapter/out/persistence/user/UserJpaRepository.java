package com.gajamy.cotream.adapter.out.persistence.user;

import com.gajamy.cotream.domain.user.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<Users, String> {
}
