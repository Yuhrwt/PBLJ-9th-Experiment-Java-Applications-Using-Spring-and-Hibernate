package com.example.bankapp;

import com.example.bankapp.service.BankingService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.bankapp.config.AppConfig;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        BankingService bankingService = context.getBean(BankingService.class);

        System.out.println("💰 Initiating Transaction...");
        try {
            bankingService.transferMoney(1, 2, 1000);
        } catch (Exception e) {
            System.out.println("❌ Transaction Failed: " + e.getMessage());
        }

        context.close();
    }
}
