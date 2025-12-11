package com.gajamy.cotream.adapter.out.persistence.user;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {
}
