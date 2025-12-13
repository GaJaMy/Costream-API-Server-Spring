package com.gajamy.cotream.application.service.auth;

import com.gajamy.cotream.adapter.out.persistence.user.UserJpaRepository;
import com.gajamy.cotream.application.dto.user.request.SignInRequest;
import com.gajamy.cotream.application.port.in.auth.SignInUseCase;
import com.gajamy.cotream.infrastructure.redis.service.TokenService;
import com.gajamy.cotream.infrastructure.security.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class SignInService implements SignInUseCase {
    private final UserJpaRepository userJpaRepository;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final JwtUtil jwtUtil;


    @Override
    @Transactional
    public void signIn(SignInRequest request) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(request.getId(), request.getPassword());

        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        UserDetails principal = (UserDetails) authenticate.getPrincipal();
        Collection<? extends GrantedAuthority> authorities = principal.getAuthorities();

        String accessToken =
                jwtUtil.generateAccessToken(principal.getUsername(), authorities.iterator().next().getAuthority());
        String refreshToken =
                jwtUtil.generateRefreshToken(principal.getUsername(), authorities.iterator().next().getAuthority());

        tokenService.saveTokens(accessToken, refreshToken, 1000 * 60 * 60 * 24L);
    }
}
