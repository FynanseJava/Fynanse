package com.fynanse.Fynanse.repositories;

import com.fynanse.Fynanse.models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transactions, Long> {
}