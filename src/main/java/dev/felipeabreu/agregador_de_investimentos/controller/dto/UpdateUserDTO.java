package dev.felipeabreu.agregador_de_investimentos.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record UpdateUserDTO(
        @Size(min = 3, message = "O campo username precisa ter pelo menos 3 letras")

        String username,
        @Email(message = "O campo email precisa ser um email válido")
        String email,

        @Size(min = 5, message = "O campo password precisa ter no mínimo 5 letras")
        String password
) {
}
