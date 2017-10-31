package com.kata.service;


import com.kata.exception.AccountNotFoundException;
import com.kata.model.Account;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountServiceTest {

    AccountService sut = new AccountService();

    @Test
    public void should_return_an_account() throws AccountNotFoundException {
        //Arrange
        String ACCOUNT_NUMBER = "01";
        Account account;
        //Act
        account = sut.getAccount(ACCOUNT_NUMBER);
        //Assert
        assertThat(account.getAccountNumber()).isEqualTo(ACCOUNT_NUMBER);
    }

    @Test(expected = AccountNotFoundException.class)
    public void should_raise_exception_when_an_account_is_not_find() throws AccountNotFoundException {
        //Arrange
        String ACCOUNT_NUMBER = "00";
        //Act
        sut.getAccount(ACCOUNT_NUMBER);
    }

}