package dev.felipeabreu.agregador_de_investimentos.controller.dto;

import dev.felipeabreu.agregador_de_investimentos.model.User;

import java.util.UUID;

public record UserResponse(
        UUID userId,
        String username,
        String email
) {

    public static UserResponse toResponse(User user) {
        var response = new UserResponse(
                user.getUserId(),
                user.getUsername(),
                user.getEmail()
        );
        
        return response;
    }
}
