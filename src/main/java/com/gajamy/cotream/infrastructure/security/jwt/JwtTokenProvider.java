package com.gajamy.cotream.infrastructure.security.jwt;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {
    @Getter
    private static final Long ACCESS_TOKEN_EXPIRATION_TIME = 1000 * 60 * 60 * 2L;

    @Getter
    private static final Long REFRESH_TOKEN_EXPIRATION_TIME = 1000 * 60 * 60 * 24L;


    public String generateAccessToken() {
        return null;
    }

    public String generateRefreshToken() {
        return null;
    }

    public String generateToken() {
        return null;
    }
}
