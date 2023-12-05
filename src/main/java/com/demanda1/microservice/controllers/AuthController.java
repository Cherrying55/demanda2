package com.demanda1.microservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demanda1.microservice.dtos.AuthenticationDTO;
import com.demanda1.microservice.entities.BERR86Partner;
import com.demanda1.microservice.services.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid AuthenticationDTO body) {

        var usernamePassword = new UsernamePasswordAuthenticationToken(body.usercertificate(), body.partnername());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = this.tokenService.generateToken((BERR86Partner) auth.getPrincipal());
        return new ResponseEntity<String>(token, HttpStatus.OK);
    }
}
