package com.fynanse.Fynanse.services;

import com.fynanse.Fynanse.models.Transactions;
import com.fynanse.Fynanse.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transactions> getAllTransactions(String username){
        return transactionRepository.findByUserUsername(username);
    }

    public void addTransaction(Transactions transaction){
        transactionRepository.save(transaction);
    }
}