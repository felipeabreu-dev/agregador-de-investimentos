package dev.felipeabreu.agregador_de_investimentos.repository;

import dev.felipeabreu.agregador_de_investimentos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByUserId(UUID id);
}
