package com.jupitters.linkage.security.jwt;

import jakarta.servlet.http.HttpServletRequest;

public class JwtUtils {
    public String getJwtFromHeader(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        if(token != null && token.startsWith("Bearer")){
            return token.substring(7);
        }
        return null;
    }
}
