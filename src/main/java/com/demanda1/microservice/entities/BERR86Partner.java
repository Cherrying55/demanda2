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

@Entity
@Table(name = "PARCEIRO_BERR86")
@Data
public class BERR86Partner {
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
}
