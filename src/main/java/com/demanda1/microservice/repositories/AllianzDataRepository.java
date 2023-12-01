package com.demanda1.microservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demanda1.microservice.entities.AllianzData;

import java.util.List;

@Repository
public interface AllianzDataRepository extends JpaRepository<AllianzData, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM PARCEIROXDADOSALLIANZ p WHERE p.ID_PARCEIRO = ?1 AND p.ID_LEVEL1 = ?2 AND p.ID_LEVEL2 = ?3")
    public List<AllianzData> searchByData(Integer id, String level1, String level2);
}
