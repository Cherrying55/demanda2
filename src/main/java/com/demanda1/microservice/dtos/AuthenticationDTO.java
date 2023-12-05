package com.demanda1.microservice.dtos;

import jakarta.validation.constraints.NotNull;

public record AuthenticationDTO(@NotNull String usercertificate, @NotNull String partnername) {

}
