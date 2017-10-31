package com.kata.service;


import com.kata.exception.NoHistoryException;
import com.kata.model.Account;
import com.kata.model.AccountOperation;
import com.kata.model.OperationType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HistoryServiceTest {

    HistoryService sut = new HistoryService();

    @Test
    public void should_return_informations_when_an_operation_is_made() throws NoHistoryException {
        //Arrange
        Account account = new Account("01", 10.0, "toto");
        final List<AccountOperation> history = new ArrayList<>();

        final AccountOperation operation = new AccountOperation(OperationType.DEPOSIT, 2.0);
        history.add(operation);

        //Act
        account.setHistory(history);
        sut.getLastOperation(account);

        //Assert
        assertThat(sut.getLastOperation(account)).hasFieldOrPropertyWithValue("OperationType",OperationType.DEPOSIT);
        assertThat(sut.getLastOperation(account)).hasFieldOrPropertyWithValue("amount",2.0);

    }
    @Test(expected =  NoHistoryException.class)
    public void should_raise_exception_when_an_account_has_no_history() throws NoHistoryException {
        //Arrange
        Account account = new Account("01", 10.0, "toto");

        //Act
        sut.getLastOperation(account);
    }

}