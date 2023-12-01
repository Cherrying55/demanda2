package com.demanda1.microservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demanda1.microservice.dtos.ConsultBERR86DTO;
import com.demanda1.microservice.dtos.ResponseDTO;
import com.demanda1.microservice.entities.AllianzData;
import com.demanda1.microservice.entities.BERR86Partner;
import com.demanda1.microservice.repositories.AllianzDataRepository;
import com.demanda1.microservice.repositories.BERR86PartnerRepository;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class DeParaService {

    @Autowired
    private AllianzDataRepository aRepository;

    @Autowired
    private BERR86PartnerRepository bRepository;

    @Transactional
    public ResponseEntity<ResponseDTO> find(ConsultBERR86DTO data) {
        List<BERR86Partner> partnersearch = bRepository.searchByIdAndUserBp(Integer.valueOf(data.userId()),
                data.userBp(), data.document());
        List<AllianzData> allianzsearch = aRepository.searchByData(Integer.valueOf(data.userId()), data.levelId1(),
                data.levelId2());
        if (partnersearch.isEmpty() || allianzsearch.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        AllianzData allianzdata = allianzsearch.get(0);
        ResponseDTO responseData = new ResponseDTO(allianzdata.getBroker(), allianzdata.getUserBA());
        return new ResponseEntity<ResponseDTO>(responseData, HttpStatus.OK);
    }

}
