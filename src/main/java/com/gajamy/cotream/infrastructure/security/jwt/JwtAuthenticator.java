package com.gajamy.cotream.infrastructure.security.jwt;

import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtAuthenticator {
    private final JwtUtil jwtUtil;
    private final RedisTemplate<String, String> redisTemplate;

    public Claims authenticate(String token) {
        String storedToken = redisTemplate.opsForValue().get(token);

        if (storedToken == null) {
            throw new RuntimeException("Invalid token");
        }

        return jwtUtil.validateToken(token);
    }
}
