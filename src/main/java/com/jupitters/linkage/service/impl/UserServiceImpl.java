package com.jupitters.linkage.service.impl;

import com.jupitters.linkage.dto.LoginRequest;
import com.jupitters.linkage.model.User;
import com.jupitters.linkage.repository.UserRepository;
import com.jupitters.linkage.security.jwt.JwtAuthenticationResponse;
import com.jupitters.linkage.security.jwt.JwtUtils;
import com.jupitters.linkage.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    @Override
    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public JwtAuthenticationResponse login(LoginRequest loginRequest) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(auth);

        UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();
        String jwt = jwtUtils.generateToken(userDetails);

        return new JwtAuthenticationResponse(jwt);
    }
}
