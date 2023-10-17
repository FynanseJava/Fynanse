package com.fynanse.Fynanse.repositories;

import com.fynanse.Fynanse.models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transactions, Long> {
    List<Transactions> findByUserUsername(String username);
}