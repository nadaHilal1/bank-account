package com.kata;

import com.kata.service.*;

import java.util.Scanner;

public class BankAccountManager {

    private static Scanner scanner;
    private static AccountService accountService;
    private static OperationService operationService;
    private static WithdrawalService withdrawalService;
    private static DepositService depositService;
    private static HistoryService historyService;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        accountService = new AccountService();
        withdrawalService = new WithdrawalService();
        depositService = new DepositService();
        historyService = new HistoryService();
        operationService = new OperationService();
        operationService.initialize();
    }

    public static Scanner getScanner() {
        if (scanner == null) {
            return new Scanner(System.in);
        }
        return scanner;
    }

    public static AccountService getAccountService() {
        if (accountService == null) {
            return new AccountService();
        }
        return accountService;
    }

    public static HistoryService getHistoryService() {
        if (historyService == null) {
            return historyService;
        }
        return historyService;
    }

    public static WithdrawalService getWithdrawalService() {
        if (withdrawalService == null) {
            return withdrawalService;
        }
        return withdrawalService;
    }

    public static DepositService getDepositService() {
        if (depositService == null) {
            return depositService;
        }
        return depositService;
    }
}
