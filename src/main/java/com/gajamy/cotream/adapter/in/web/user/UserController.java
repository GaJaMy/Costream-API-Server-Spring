package com.gajamy.cotream.adapter.in.web.user;

import com.gajamy.cotream.application.dto.user.request.SignUpRequest;
import com.gajamy.cotream.application.port.in.user.RegisterUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final RegisterUserUseCase registerUserUseCase;

    @PostMapping
    public ResponseEntity<?> registerUser(@RequestBody SignUpRequest request) {
        registerUserUseCase.registerUser(request);
        return ResponseEntity.ok("ok");
    }
}
