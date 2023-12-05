package com.demanda1.microservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping(value = "/data-access", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
    public ResponseEntity<ResponseDTO> returnTest(@RequestBody MultiValueMap<String, String> paramMap)
            throws Exception {
        String currentUsername = "";
        /*
         * @NotNull String document,
         * 
         * @NotNull String userBp,
         * 
         * @NotNull String userBa,
         * 
         * @NotNull String userId,
         * 
         * @NotNull String levelId1,
         * 
         * @NotNull String levelId2
         */
        String document = paramMap.getFirst("document");
        String userBp = paramMap.getFirst("userBp");
        String userBa = paramMap.getFirst("userBa");
        String userId = paramMap.getFirst("userId");
        String levelId1 = paramMap.getFirst("levelId1");
        String levelId2 = paramMap.getFirst("levelId2");
        ConsultBERR86DTO data = new ConsultBERR86DTO(document, userBp, userBa, userId, levelId1, levelId2);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUsername = authentication.getName();
            System.out.println(currentUsername);
        }
        return deParaService.testing(data, currentUsername);
    }

}
