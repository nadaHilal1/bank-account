package com.kata.service;

import com.kata.exception.AccountNotFoundException;
import com.kata.model.Account;
import com.kata.model.Error;

import java.util.ArrayList;
import java.util.List;


public class AccountService {

    private final static List<Account> accounts;

    static {
        accounts = new ArrayList<>();
        accounts.add(new Account("01", 10.0, "toto"));
        accounts.add(new Account("02", 20.0, "titi"));
        accounts.add(new Account("03", 30.0, "tata"));
        accounts.add(new Account("04", 40.0, "tutu"));
    }

    public Account getAccount(final String accountNumber) throws AccountNotFoundException {
        Account foundAccount = accounts.stream().filter(account -> account.getAccountNumber().equals(accountNumber)).findAny()                                      // If 'findAny' then return found
                .orElse(null);
        if (null == foundAccount) {
            throw new AccountNotFoundException(Error.WRONG_ACCOUNT_NUMBER.getErrorMessage());
        }
        return foundAccount;
    }

}
