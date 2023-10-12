package com.fynanse.Fynanse.api.services;

import com.fynanse.Fynanse.api.models.Account;
import com.fynanse.Fynanse.api.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@EnableScheduling
public class ScheduledTasks {
    @Autowired
    private AccountRepository accountRepository;

    @Scheduled(cron = "0 0 0 * * 6")
    public void updateWeeklySpent(){
        List<Account> accountList = new ArrayList<>();
        accountRepository.findAll().forEach(accountList::add);
        for(Account acc: accountList){
            acc.setWeeklySpent(0.0);
            accountRepository.save(acc);
        }

    }
    @Scheduled(cron = "0 0 0 1 * *")
    public void updateMonthlySpent(){
        List<Account> accountList = new ArrayList<>();
        accountRepository.findAll().forEach(accountList::add);
        for(Account acc: accountList){
            acc.setMonthlySpent(0.0);
            accountRepository.save(acc);
        }

    }
}