package com.example.bankapp.service;

import com.example.bankapp.dao.AccountDAO;
import com.example.bankapp.entity.Account;
import com.example.bankapp.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankingService {

    @Autowired
    private AccountDAO accountDAO;

    @Transactional
    public void transferMoney(int fromAccountId, int toAccountId, double amount) {
        Account fromAcc = accountDAO.getAccountById(fromAccountId);
        Account toAcc = accountDAO.getAccountById(toAccountId);

        if (fromAcc == null || toAcc == null) {
            throw new RuntimeException("❌ Account not found!");
        }

        if (fromAcc.getBalance() < amount) {
            throw new RuntimeException("⚠️ Insufficient balance in source account!");
        }

        // Deduct and add money
        fromAcc.setBalance(fromAcc.getBalance() - amount);
        toAcc.setBalance(toAcc.getBalance() + amount);

        // Update accounts
        accountDAO.updateAccount(fromAcc);
        accountDAO.updateAccount(toAcc);

        // Record transaction
        Transaction transaction = new Transaction(fromAccountId, toAccountId, amount);
        accountDAO.saveTransaction(transaction);

        System.out.println("✅ Transaction Successful: " + transaction);
    }
}
