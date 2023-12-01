package com.demanda1.microservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demanda1.microservice.dtos.ConsultBERR86DTO;
import com.demanda1.microservice.dtos.ResponseDTO;
import com.demanda1.microservice.services.DeParaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1")
public class DeParaController {

    @Autowired
    private DeParaService deParaService;

    @GetMapping("/data-access")
    public ResponseEntity<ResponseDTO> returnBrokerandUserBa(@RequestBody @Valid ConsultBERR86DTO request) {
        return deParaService.find(request);
    }

}
