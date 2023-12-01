package com.demanda1.microservice.dtos;

import jakarta.validation.constraints.NotNull;

public record ConsultBERR86DTO(
        @NotNull String document,
        @NotNull String userBp,
        @NotNull String userBa,
        @NotNull String userId,
        @NotNull String levelId1,
        @NotNull String levelId2) {

}
