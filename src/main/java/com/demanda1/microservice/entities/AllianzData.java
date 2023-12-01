package com.demanda1.microservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import java.time.LocalDateTime;
import jakarta.persistence.OneToOne;
import jakarta.persistence.CascadeType;

@Entity
@Table(name = "PARCEIROXDADOSALLIANZ")
@Data
public class AllianzData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false, columnDefinition = "INTEGER")
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_PARCEIRO", referencedColumnName = "ID_PARCEIRO")
    private BERR86Partner partner;

    @Column(name = "ID_LEVEL1", columnDefinition = "VARCHAR(30)", nullable = false)
    private String idlevel1;

    @Column(name = "ID_LEVEL2", columnDefinition = "VARCHAR(30)", nullable = false)
    private String idlevel2;

    @Column(name = "CD_MEDIADOR", columnDefinition = "CHAR(7)", nullable = false)
    private String broker;

    @Column(name = "DS_USUARIO_BA", columnDefinition = "CHAR(8)", nullable = false)
    private String userBA;

    @Column(name = "CD_USR_INCLUSAO", columnDefinition = "CHAR(15)", nullable = false)
    private String inclusionusercode;

    @Column(name = "DT_INCLUSAO", columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDateTime inclusiondate;

    @Column(name = "CD_USR_ATUALIZACAO", columnDefinition = "CHAR(15)")
    private String updateusercode;

    @Column(name = "DT_ATUALIZACAO", columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedate;

    public AllianzData() {

    }
}
