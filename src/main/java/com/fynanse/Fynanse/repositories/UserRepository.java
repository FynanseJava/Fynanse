package com.fynanse.Fynanse.repositories;

import com.fynanse.Fynanse.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, String> {
}