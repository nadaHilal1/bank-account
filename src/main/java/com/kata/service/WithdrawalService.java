package com.kata.service;

import com.kata.exception.NoHistoryException;
import com.kata.exception.UnsufficientBalanceException;
import com.kata.model.Account;
import com.kata.model.Error;
import com.kata.model.Messages;
import com.kata.model.OperationType;

import static com.kata.BankAccountManager.getHistoryService;
import static com.kata.BankAccountManager.getScanner;

public class WithdrawalService {

    /**
     *
     * @param accountToWithdrawFrom
     * @throws UnsufficientBalanceException
     */
    public void withdraw(Account accountToWithdrawFrom) throws UnsufficientBalanceException {
        System.out.println(Messages.FILL_AMOUNT.getMessage());
        String amount = getScanner().nextLine();
        final double amountAsDouble = Double.parseDouble(amount);
        final double balanceAfterWithdrawal = accountToWithdrawFrom.getBalance() - amountAsDouble;
        if (balanceAfterWithdrawal < 0) {
            throw new UnsufficientBalanceException(Error.UNSUFFICIENT_BALANCE.getErrorMessage());
        }
        accountToWithdrawFrom.setBalance(balanceAfterWithdrawal);
        getHistoryService().historize(accountToWithdrawFrom, OperationType.WITHDRAWAL, amountAsDouble);
    }

    /**
     *
     * @param accountToWithdrawFrom
     * @throws UnsufficientBalanceException
     * @throws NoHistoryException
     */
    public void withdrawWithTicket(Account accountToWithdrawFrom) throws UnsufficientBalanceException, NoHistoryException {
        withdraw(accountToWithdrawFrom);
        System.out.println(getHistoryService().getLastOperation(accountToWithdrawFrom).toString());
    }

}
