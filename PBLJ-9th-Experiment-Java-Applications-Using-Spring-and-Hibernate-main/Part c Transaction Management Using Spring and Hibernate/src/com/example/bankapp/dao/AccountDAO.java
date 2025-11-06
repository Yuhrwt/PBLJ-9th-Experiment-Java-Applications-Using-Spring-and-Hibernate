package com.example.bankapp.dao;

import com.example.bankapp.entity.Account;
import com.example.bankapp.entity.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Account getAccountById(int id) {
        return sessionFactory.getCurrentSession().get(Account.class, id);
    }

    public void updateAccount(Account account) {
        sessionFactory.getCurrentSession().merge(account);
    }

    public void saveTransaction(Transaction transaction) {
        sessionFactory.getCurrentSession().persist(transaction);
    }
}
