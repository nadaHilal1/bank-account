package com.kata.model;

import com.kata.exception.NoHistoryException;
import com.kata.exception.UnsufficientBalanceException;

import static com.kata.BankAccountManager.*;

public enum Operation {

    WITHDRAW_WITHOUT_TICKET("1") {
        @Override
        public void doOperation(Account account) throws UnsufficientBalanceException {
            getWithdrawalService().withdraw(account);
        }
    },
    WITHDRAW_WITH_TICKET("2") {
        @Override
        public void doOperation(Account account) throws UnsufficientBalanceException, NoHistoryException {
            getWithdrawalService().withdrawWithTicket(account);
        }
    },
    DEPOSIT_WITH_TICKET("3") {
        @Override
        public void doOperation(Account account) throws UnsufficientBalanceException, NoHistoryException {
            getDepositService().depositWithTicket(account);
        }
    },
    DEPOSIT_WITHOUT_TICKET("4") {
        @Override
        public void doOperation(Account account) {
            getDepositService().deposit(account);
        }
    },
    PRINT_HISTORY("5") {
        @Override
        public void doOperation(Account account) {
            getHistoryService().getHistory(account);
        }
    };

    private String choice;

    Operation(String choice) {
        this.choice = choice;
    }

    public String getChoice() {
        return choice;
    }

    public static Operation fromNumber(String number) {
        for (Operation choice : Operation.values()) {
            if (number.equals(choice.choice)) {
                return choice;
            }
        }
        return null;
    }

    public abstract void doOperation(Account account) throws UnsufficientBalanceException, NoHistoryException;
}
