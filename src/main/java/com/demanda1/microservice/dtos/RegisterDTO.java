package com.demanda1.microservice.dtos;

import jakarta.validation.constraints.NotNull;

public record RegisterDTO(@NotNull String partnername, @NotNull String documentnumber,
        @NotNull String usercertificate, @NotNull String inclusionusercode, @NotNull String role) {
}
