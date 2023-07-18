package com.booleanuk.core;

import com.booleanuk.core.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {
    Customer customer;
    @BeforeEach
    public void Setup()
    {
         customer = new Customer();
    }
    @Test
    public void customerCreateAccountTest_shouldBeAddedToCustomerAccountsList()
    {
        customer.createAccount("currentAccount");
        Assertions.assertEquals(1,customer.getAccountsList().size());
    }
    @Test
    public void customerWithdrawMoney_notEnoughMoney()
    {
        customer.createAccount("currentAccount");
        boolean result = customer.withdrawMoney(customer.getAccountsList().get(0),200);
        Assertions.assertFalse(result);
    }
    @Test
    public void customerWithdrawMoney_EnoughMoney()
    {
        customer.createAccount("currentAccount");
        customer.depositMoney(customer.getAccountsList().get(0),20000);
        boolean result = customer.withdrawMoney(customer.getAccountsList().get(0),200);
        Assertions.assertTrue(result);
    }
    @Test
    public void customerDepositMoney_shouldBeAddedToAccountBalance()
    {
        customer.createAccount("currentAccount");
        customer.depositMoney(customer.getAccountsList().get(0),20000);
        Assertions.assertEquals(200,customer.getAccountsList().get(0).getCurrentBalance());
    }
    @Test
    public void customerCheckAccountBalanceTest()
    {
        customer.createAccount("currentAccount");
        customer.depositMoney(customer.getAccountsList().get(0),20000);
        double result = customer.checkAccountBalance(customer.getAccountsList().get(0));
        Assertions.assertEquals(200.00,result);
    }
}