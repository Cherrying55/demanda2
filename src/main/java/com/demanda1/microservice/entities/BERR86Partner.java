package com.demanda1.microservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.demanda1.microservice.dtos.RegisterDTO;

@Entity
@Table(name = "PARCEIRO_BERR86")
@Data
public class BERR86Partner implements UserDetails {

    @Column(name = "USR_ROLE")
    private String role;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_PARCEIRO", updatable = false, nullable = false, columnDefinition = "INTEGER")
    private int id;

    @Column(name = "NM_PARCEIRO", nullable = false, columnDefinition = "VARCHAR(100)")
    private String partnername;

    @Column(name = "NR_DOCUMENTO_PARCEIRO", nullable = false, columnDefinition = "VARCHAR(14)")
    private String documentnumber;

    @Column(name = "CD_USR_CERTIFICADO", nullable = false, columnDefinition = "CHAR(8)")
    private String usercertificate;

    @Column(name = "CD_USR_INCLUSAO", columnDefinition = "CHAR(15)", nullable = false)
    private String inclusionusercode;

    @Column(name = "DT_INCLUSAO", columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDateTime inclusiondate;

    @Column(name = "CD_USR_ATUALIZACAO", columnDefinition = "CHAR(15)")
    private String updateusercode;

    @Column(name = "DT_ATUALIZACAO", columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedate;

    @OneToOne(mappedBy = "partner")
    private AllianzData allianzdata;

    public BERR86Partner() {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println(this.role.toString().equals("ADMIN"));
        if (this.role.equals("ADMIN")) {
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        } else {
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }

    @Override
    public String getPassword() {
        return this.partnername;

    }

    public String getRole() {
        return this.getRole();
    }

    @Override
    public String getUsername() {
        return this.usercertificate;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;

    }

    @Override
    public boolean isAccountNonLocked() {
        return true;

    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;

    }

    @Override
    public boolean isEnabled() {
        return true;

    }

    public BERR86Partner(RegisterDTO data) {
        this.partnername = data.partnername();
        this.documentnumber = data.documentnumber();
        this.usercertificate = data.usercertificate();
        this.inclusionusercode = data.inclusionusercode();
        this.inclusiondate = LocalDateTime.now();
    }
}
