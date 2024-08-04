package com.mostafa.test.sec06;

import com.mostafa.models.sec06.AccountBalance;
import com.mostafa.models.sec06.BalanceCheckRequest;
import io.grpc.stub.StreamObserver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;

public class Lec02UnaryAsyncClientTest extends AbstractTest {

    @Test
    public void getBalanceTest() throws InterruptedException {
        var request = BalanceCheckRequest.newBuilder().setAccountNumber(1).build();
        var latch = new CountDownLatch(1);
        this.stub.getAccountBalance(request, new StreamObserver<AccountBalance>() {
            @Override
            public void onNext(AccountBalance accountBalance) {
                System.out.println("async balance received " + accountBalance);
                try {
                    Assertions.assertEquals(500, accountBalance.getBalance());
                } finally {
                    latch.countDown();
                }
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {

            }
        });
        latch.await();
    }
}
