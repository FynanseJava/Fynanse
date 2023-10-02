package com.fynanse.Fynanse.api.repositories;

import com.fynanse.Fynanse.api.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface UserRepository extends CrudRepository<User, String>{

}