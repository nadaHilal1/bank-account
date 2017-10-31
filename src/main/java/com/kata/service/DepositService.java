package com.kata.service;

import com.kata.exception.NoHistoryException;
import com.kata.model.Account;
import com.kata.model.Messages;
import com.kata.model.OperationType;

import static com.kata.BankAccountManager.getHistoryService;
import static com.kata.BankAccountManager.getScanner;

public class DepositService {

    public void deposit(Account accountToDepositOn) {
        System.out.println(Messages.FILL_AMOUNT.getMessage());
        String amount = getScanner().nextLine();
        final double amountAsDouble = Double.parseDouble(amount);
        final double balanceAfterDeposit = accountToDepositOn.getBalance() + amountAsDouble;
        accountToDepositOn.setBalance(balanceAfterDeposit);
        getHistoryService().historize(accountToDepositOn, OperationType.DEPOSIT, amountAsDouble);
    }


    public String depositWithTicket(Account accountToDepositOn) throws NoHistoryException {
        deposit(accountToDepositOn);
        return getHistoryService().getLastOperation(accountToDepositOn).toString();
    }
}
