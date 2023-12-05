package com.demanda1.microservice.services;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.demanda1.microservice.entities.BERR86Partner;

@Service
public class TokenService {

    public String generateToken(BERR86Partner partner) throws JWTCreationException {
        try {
            String secret = "secret1";
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("microservice")
                    .withSubject(partner.getUsercertificate())
                    .withExpiresAt(LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00")))
                    .sign(algorithm); // assinatura e geraçao
            return token;
        } catch (JWTCreationException e) {
            throw new RuntimeException("Error while generating token", e);
        }

    }

    public String validateToken(String token) throws JWTVerificationException {
        try {
            String secret = "secret1";
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("microservice")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException e) {
            return "";
        }

    }
}
