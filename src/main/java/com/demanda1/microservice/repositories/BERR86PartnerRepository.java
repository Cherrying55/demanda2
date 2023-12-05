package com.demanda1.microservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.demanda1.microservice.entities.BERR86Partner;

@Repository
public interface BERR86PartnerRepository extends JpaRepository<BERR86Partner, Integer> {

    @Query("from BERR86Partner p where p.id = :userId and p.usercertificate = :userBp and p.documentnumber = :document")
    public List<BERR86Partner> searchByIdAndUserBp(Integer userId, String userBp, String document);

    public UserDetails findByUsercertificate(String username);
}
