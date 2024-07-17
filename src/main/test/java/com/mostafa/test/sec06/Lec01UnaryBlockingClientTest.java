package com.mostafa.test.sec06;

import com.mostafa.models.sec06.BalanceCheckRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Lec01UnaryBlockingClientTest extends AbstractTest {

    @Test
    public void getBalanceTest() {
        var request = BalanceCheckRequest.newBuilder()
                .setAccountNumber(10)
                .build();
        var balance = this.blockingStub.getAccountBalance(request);
        System.out.println("balance received = " + balance);
        Assertions.assertEquals(100, balance.getBalance());
    }
}
