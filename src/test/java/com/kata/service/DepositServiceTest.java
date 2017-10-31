package com.kata.service;


import com.kata.model.Account;
import org.junit.Test;
import org.mockito.Mockito;

import static com.kata.BankAccountManager.getScanner;
import static org.assertj.core.api.Assertions.assertThat;
public class DepositServiceTest {

    DepositService sut = new DepositService();

    @Test
    public void should_raise_balace_when_a_deposit_is_made() {
        //Arrange
        Account accountToDepositOn = new Account("01", 10.0, "toto");
        Double balanceBeforeDeposit = 10.0;

        //Act
        Mockito.when(getScanner().nextLine()).thenReturn("2");
        sut.deposit(accountToDepositOn);

        //Assert
        assertThat(accountToDepositOn.getBalance()).isEqualTo(balanceBeforeDeposit+2);

    }


}