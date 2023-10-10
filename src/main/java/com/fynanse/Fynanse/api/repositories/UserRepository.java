package com.fynanse.Fynanse.api.repositories;

import com.fynanse.Fynanse.api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    public Optional<User> findByLoggedInTrue();
}