package com.fynanse.Fynanse.repositories;

import com.fynanse.Fynanse.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    public Set<Transaction> findByUserUsername(String username);
}