package com.fynanse.Fynanse.repositories;

import com.fynanse.Fynanse.models.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
    public Account findByUserUsername(String username);
}