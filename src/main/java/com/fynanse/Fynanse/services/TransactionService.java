package com.fynanse.Fynanse.services;

import com.fynanse.Fynanse.models.Transaction;
import com.fynanse.Fynanse.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public Set<Transaction> getAllTransactions(String username){
        return transactionRepository.findByUserUsername(username);
    }

    public void addTransaction(Transaction transaction){
        transactionRepository.save(transaction);
    }
}