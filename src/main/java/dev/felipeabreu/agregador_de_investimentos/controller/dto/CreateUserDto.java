package dev.felipeabreu.agregador_de_investimentos.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateUserDto(
        @NotBlank(message = "O campo username precisa ser preenchido")
        @Size(min = 3, message = "O campo username precisa ter pelo menos 3 letras")
        String username,

        @NotBlank(message = "O campo email precisa ser preenchido")
        @Email(message = "O campo email precisa ser um email válido")
        String email,

        @NotBlank(message = "O campo password precisa ser preenchido")
        @Size(min = 5, message = "O campo password precisa ter no mínimo 5 letras")
        String password
) {
}
