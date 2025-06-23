package com.example.qr_system.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class TokenService {
    private final Map<Long, String> tokenStorage = new HashMap<>();

    public String generateToken(Long studentId) {
        String token = UUID.randomUUID().toString();
        tokenStorage.put(studentId, token);
        return token;
    }

    public boolean validateToken(Long studentId, String token) {
        return token.equals(tokenStorage.get(studentId));
    }
}