package dev.felipeabreu.agregador_de_investimentos.controller;

import dev.felipeabreu.agregador_de_investimentos.controller.dto.CreateUserDto;
import dev.felipeabreu.agregador_de_investimentos.controller.dto.UpdateUserDTO;
import dev.felipeabreu.agregador_de_investimentos.controller.dto.UserResponse;
import dev.felipeabreu.agregador_de_investimentos.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody CreateUserDto user) {
        var response = userService.createUser(user);

        return ResponseEntity.created(
                URI.create("/v1/users/" + response.userId().toString())
                )
                .build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findUserById(@PathVariable UUID id) {
        var response = userService.findUserById(id);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }

        //
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<?> getUsers() {
        var response = userService.getUsers();

        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateUser(@PathVariable UUID id, @RequestBody UpdateUserDTO dto) {
        UserResponse response = userService.updateUserById(id, dto);

        if(response == null) {
            return ResponseEntity.badRequest().build();
        }
        //
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteUser(@PathVariable UUID id) {
        var response = userService.deleteUser(id);

        if(response == null) {
            return ResponseEntity.notFound().build();
        }

        //
        return ResponseEntity.noContent().build();
    }
}
