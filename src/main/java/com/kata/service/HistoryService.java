package com.kata.service;

import com.kata.exception.NoHistoryException;
import com.kata.model.Account;
import com.kata.model.AccountOperation;
import com.kata.model.Error;
import com.kata.model.OperationType;

import java.util.List;


public class HistoryService {

    public void historize(Account accountToDepositOn, OperationType operationType, double amount) {
        accountToDepositOn.getHistory().add(new AccountOperation(operationType, amount));
    }

    public AccountOperation getLastOperation(Account account) throws NoHistoryException {
        final List<AccountOperation> history = account.getHistory();
        if (history.isEmpty()) {
            throw new NoHistoryException(Error.NO_HISTORY.getErrorMessage());
        }
        return history.get(history.size() - 1);
    }

    public void getHistory(Account account) {
        final List<AccountOperation> history = account.getHistory();
        if (history.isEmpty()) {
            System.out.println(Error.NO_HISTORY.getErrorMessage());
        }
        history.forEach(operation -> System.out.println(operation.toString()));

    }
}
