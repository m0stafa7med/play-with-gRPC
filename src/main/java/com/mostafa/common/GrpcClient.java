package com.mostafa.common;

import com.mostafa.models.sec06.AccountBalance;
import com.mostafa.models.sec06.BalanceCheckRequest;
import com.mostafa.models.sec06.BankServiceGrpc;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.time.Duration;

public class GrpcClient {
    public static void main(String[] args) throws InterruptedException {
        var channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext()
                .build();


        var stub = BankServiceGrpc.newStub(channel);

        stub.getAccountBalance(BalanceCheckRequest.newBuilder().setAccountNumber(2).build(),
                new StreamObserver<>() {
            @Override
            public void onNext(AccountBalance accountBalance) {
                System.out.println(accountBalance);
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public void onCompleted() {
                System.out.println("completed");
            }
        });


        Thread.sleep(1000);

    }
}
