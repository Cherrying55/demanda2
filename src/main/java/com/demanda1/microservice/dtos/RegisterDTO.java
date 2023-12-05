package com.demanda1.microservice.dtos;

import jakarta.validation.constraints.NotNull;

public record RegisterDTO(@NotNull String partnername, @NotNull String documentnumber,
        @NotNull String usercertificate, @NotNull String inclusionusercode, @NotNull String role) {

    /*
     * {"document": "91586982000281", "userBp": "BP999999", "userBa": "BA809453",
     * "userId": "1", "levelId1": "1233453456", "levelId2": "1123"}
     * ID_PARCEIRO, NM_PARCEIRO, NR_DOCUMENTO_PARCEIRO, CD_USR_CERTIFICADO,
     * CD_USR_INCLUSAO
     * 
     * @Id
     * 
     * @GeneratedValue(strategy = GenerationType.AUTO)
     * 
     * @Column(name = "ID_PARCEIRO", updatable = false, nullable = false,
     * columnDefinition = "INTEGER")
     * private int id;
     * 
     * @Column(name = "NM_PARCEIRO", nullable = false, columnDefinition =
     * "VARCHAR(100)")
     * private String partnername;
     * 
     * @Column(name = "NR_DOCUMENTO_PARCEIRO", nullable = false, columnDefinition =
     * "VARCHAR(14)")
     * private String documentnumber;
     * 
     * @Column(name = "CD_USR_CERTIFICADO", nullable = false, columnDefinition =
     * "CHAR(8)")
     * private String usercertificate;
     * 
     * @Column(name = "CD_USR_INCLUSAO", columnDefinition = "CHAR(15)", nullable =
     * false)
     * private String inclusionusercode;
     * 
     * @Column(name = "DT_INCLUSAO", columnDefinition = "TIMESTAMP", nullable =
     * false)
     * private LocalDateTime inclusiondate;
     * 
     * @Column(name = "CD_USR_ATUALIZACAO", columnDefinition = "CHAR(15)")
     * private String updateusercode;
     * 
     * @Column(name = "DT_ATUALIZACAO", columnDefinition = "TIMESTAMP")
     * private LocalDateTime updatedate;
     */
}
