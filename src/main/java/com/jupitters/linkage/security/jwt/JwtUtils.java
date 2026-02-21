package com.jupitters.linkage.security.jwt;

import com.jupitters.linkage.service.UserDetailsImpl;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Date;
import java.util.stream.Collectors;

public class JwtUtils {
    public String getJwtFromHeader(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        if(token != null && token.startsWith("Bearer")){
            return token.substring(7);
        }
        return null;
    }
    
    public String generateToken(UserDetailsImpl user){
        String username = user.getUsername();
        String roles = user.getAuthorities().stream()
                .map(authority -> authority.getAuthority())
                .collect(Collectors.joining(","));
        return Jwts.builder()
                .subject(username)
                .claim("roles", roles)
                .issuedAt(new Date())
                .expiration(new Date(new Date().getTime() + 172800000))
                .signWith()
                .compact();
    }
}
