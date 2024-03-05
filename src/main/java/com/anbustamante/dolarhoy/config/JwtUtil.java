package com.anbustamante.dolarhoy.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    private static String dolar4pi = "dolar4pi";
    private static Algorithm ALGORITHM = Algorithm.HMAC256(dolar4pi);
    public String create(String username) {
        return JWT.create()
                .withSubject(username)
                .withIssuer("dolarapi")
                .withIssuedAt(new Date(System.currentTimeMillis()))
                .withExpiresAt(new Date(System.currentTimeMillis() + 600000))
                .sign(ALGORITHM);

    }

    public boolean isValid(String token) {
        try {
            JWT.require(ALGORITHM)
                    .build()
                    .verify(token);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public String getUsername(String token) {
        return JWT.require(ALGORITHM)
                .build()
                .verify(token)
                .getSubject();
    }

    public String getCredentials(String jwt) {
        return JWT.require(ALGORITHM)
                .build()
                .verify(jwt)
                .getSubject();
    }
}