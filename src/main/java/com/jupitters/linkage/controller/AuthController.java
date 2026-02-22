package com.jupitters.linkage.controller;

import com.jupitters.linkage.dto.RegisterRequest;
import com.jupitters.linkage.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest){
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
        user.setRole("USER_ROLE");
        userService.registerUser(user);

        return ResponseEntity.ok("User registered successfully");
    }
}
