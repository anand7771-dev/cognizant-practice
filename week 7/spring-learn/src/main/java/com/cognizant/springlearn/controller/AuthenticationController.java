package com.cognizant.springlearn.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final SecretKey SECRET_KEY =
            Keys.hmacShaKeyFor(
                    "ThisIsASecretKeyForJwtAuthentication123456789".getBytes(StandardCharsets.UTF_8));

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(
            @RequestHeader("Authorization") String authorizationHeader) {

        String username = getUsername(authorizationHeader);

        String token = Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1200000))
                .signWith(SECRET_KEY)
                .compact();

        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        return response;
    }

    private String getUsername(String authHeader) {

        String encodedCredentials = authHeader.substring(6);

        byte[] decoded = Base64.getDecoder().decode(encodedCredentials);

        String credentials = new String(decoded);

        return credentials.split(":")[0];
    }
}