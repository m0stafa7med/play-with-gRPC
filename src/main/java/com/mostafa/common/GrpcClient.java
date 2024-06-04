package com.mostafa.common;

import com.mostafa.models.sec06.BalanceCheckRequest;
import com.mostafa.models.sec06.BankServiceGrpc;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) {
        var channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext()
                .build();


        var stab = BankServiceGrpc.newBlockingStub(channel);

        var accountBalance = stab.getAccountBalance(BalanceCheckRequest.newBuilder()
                .setAccountNumber(2).build());


        System.out.println("accountBalance = " + accountBalance);
    }
}
