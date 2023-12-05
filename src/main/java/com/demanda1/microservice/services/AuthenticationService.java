package com.demanda1.microservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demanda1.microservice.repositories.BERR86PartnerRepository;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private BERR86PartnerRepository bRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return bRepository.findByUsercertificate(username);
    }

}
