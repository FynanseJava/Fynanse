package com.fynanse.Fynanse.api.repositories;

import com.fynanse.Fynanse.api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, String> {
}