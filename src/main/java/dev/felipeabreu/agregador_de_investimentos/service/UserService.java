package dev.felipeabreu.agregador_de_investimentos.service;

import dev.felipeabreu.agregador_de_investimentos.controller.dto.CreateUserDto;
import dev.felipeabreu.agregador_de_investimentos.controller.dto.UpdateUserDTO;
import dev.felipeabreu.agregador_de_investimentos.controller.dto.UserResponse;
import dev.felipeabreu.agregador_de_investimentos.model.User;
import dev.felipeabreu.agregador_de_investimentos.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse createUser(CreateUserDto request) {
        var user = new User();
        user.setUsername(request.username());
        user.setEmail(request.email());
        user.setPassword(request.password());

        var response = userRepository.save(user);

        return UserResponse.toResponse(response);
    }

    public User findUserById(UUID id) {
        return userRepository.findByUserId(id).orElse(null);
    }

    public List<UserResponse> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserResponse::toResponse)
                .toList();
    }
    public UserResponse updateUserById(UUID userId, UpdateUserDTO dto) {
        var actualUser = userRepository.findByUserId(userId);

        if(!actualUser.isPresent()) {
            return null;
        } else {
            var updatedUser = actualUser.get();

            if (!dto.username().isBlank()) {
                updatedUser.setUsername(dto.username());
            }

            if (!dto.email().isBlank()) {
                updatedUser.setEmail(dto.email());
            }

            if (!dto.password().isBlank()) {
                updatedUser.setPassword(dto.password());
            }

            var user = userRepository.save(updatedUser);
            return UserResponse.toResponse(user);
        }
    }

    public UserResponse deleteUser(UUID id) {
        var user = userRepository.findByUserId(id);

        if(!user.isPresent()) {
            return null;
        }

        userRepository.delete(user.get());
        return UserResponse.toResponse(user.get());
    }
}
