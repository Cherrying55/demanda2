package com.demanda1.microservice.dtos;

import jakarta.validation.constraints.NotNull;

public record ResponseDTO(@NotNull String broker, @NotNull String userBA) {

}
