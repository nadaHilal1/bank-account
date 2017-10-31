package com.kata.service;


import com.kata.exception.AccountNotFoundException;
import com.kata.exception.NoHistoryException;
import com.kata.exception.UnsufficientBalanceException;
import com.kata.model.Account;
import com.kata.model.Error;
import com.kata.model.Messages;
import com.kata.model.Operation;

import java.math.BigDecimal;

import static com.kata.BankAccountManager.getAccountService;
import static com.kata.BankAccountManager.getScanner;

public class OperationService {

    private String exitOrContinue = "o";

    public void initialize() {
        String accountNumber = printMessageAndReturnNextLine(Messages.FILL_ACCOUNT_NUMBER.getMessage());
        try {
            computeChoiceAndDoOperation(getAccountService().getAccount(accountNumber));
        } catch (AccountNotFoundException accountNotFoundException) {
            System.out.println(Error.WRONG_ACCOUNT_NUMBER.getErrorMessage());
            exit();
            initialize();
        }
    }

    /**
     * @param message
     * @return
     */
    private String printMessageAndReturnNextLine(String message) {
        System.out.println(message);
        return getScanner().nextLine();
    }

    /**
     * @param account
     */
    private void computeChoiceAndDoOperation(Account account) {
        while (true) {
            String userChoice = printMessageAndReturnNextLine(Messages.OPERATION_CHOICES.getMessage());
            Operation choice = getChoiceFromUserInput(userChoice);
            if (choice == null) {
                throw new UnsupportedOperationException(Error.WRONG_CHOICE.getErrorMessage());
            }

            try {
                choice.doOperation(account);
                exit();
            } catch (UnsufficientBalanceException e) {
                System.out.println(Error.UNSUFFICIENT_BALANCE.getErrorMessage());
                computeChoiceAndDoOperation(account);
            } catch (NoHistoryException e) {
                System.out.println(Error.NO_HISTORY.getErrorMessage());
                computeChoiceAndDoOperation(account);
            }
        }
    }

    /**
     * @param choice
     * @return
     */
    private Operation getChoiceFromUserInput(String choice) {
        return Operation.fromNumber(choice);
    }

    private void exit() {
        System.out.println(Messages.EXIT.getMessage());
        getScanner().nextLine();
        exitOrContinue = getScanner().nextLine();
        if (exitOrContinue.equals("n")) {
            System.exit(BigDecimal.ZERO.intValue());
            getScanner().close();
        }
    }
}
