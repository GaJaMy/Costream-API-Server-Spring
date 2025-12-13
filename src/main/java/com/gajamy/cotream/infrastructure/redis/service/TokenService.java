package com.gajamy.cotream.infrastructure.redis.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class TokenService {
    private final RedisTemplate<String, String> redisTemplate;

    public void saveTokens(String accessToken, String refreshToken, Long ttl) {
        redisTemplate.opsForValue().set(accessToken, refreshToken, ttl, TimeUnit.SECONDS);
    }
}
