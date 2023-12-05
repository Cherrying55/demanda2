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
import com.demanda1.microservice.dtos.RegisterDTO;
import com.demanda1.microservice.entities.BERR86Partner;
import com.demanda1.microservice.repositories.BERR86PartnerRepository;
import com.demanda1.microservice.services.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private BERR86PartnerRepository bRepository;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid AuthenticationDTO body) {

        var usernamePassword = new UsernamePasswordAuthenticationToken(body.usercertificate(), body.partnername());
        var partner = bRepository.findByUsercertificate(body.usercertificate());
        System.out.println(partner.getUsername());
        var roles = partner.getAuthorities();
        var role = roles.iterator().next();
        var str = role.toString();
        System.out.println(str);
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = this.tokenService.generateToken((BERR86Partner) auth.getPrincipal());
        return new ResponseEntity<String>(token, HttpStatus.OK);
    }
}
