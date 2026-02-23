package com.jupitters.linkage.service;

import com.jupitters.linkage.dto.LoginRequest;
import com.jupitters.linkage.model.User;
import com.jupitters.linkage.security.jwt.JwtAuthenticationFilter;
import com.jupitters.linkage.security.jwt.JwtAuthenticationResponse;

public interface UserService {
    User registerUser(User user);
    JwtAuthenticationResponse login(LoginRequest loginRequest);
    User findByUsername(String username);
}
