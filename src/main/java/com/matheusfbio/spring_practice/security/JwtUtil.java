package com.matheusfbio.spring_practice.security;

import java.security.Key;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {
    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final long EXPIRATION_TIME = 86400000; // 1 day in milliseconds  

    public static String generateToken(String username) {
        long now = System.currentTimeMillis();
        return io.jsonwebtoken.Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new java.util.Date(now))
                .setExpiration(new java.util.Date(now + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }

    public static String extractUsername(String token){
        return Jwts.parserBuilder().setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public static boolean validateToken(String token){
        try {
            Jwts.parserBuilder().setSigningKey(key)
            .build().parseClaimsJws(token);
            return true;
            
        } catch (JwtException e) {
            return false;
            
        }
    }
}
