package com.fynanse.Fynanse.api.repositories;

import com.fynanse.Fynanse.api.models.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
    public Account findByUserUsername(String username);
}