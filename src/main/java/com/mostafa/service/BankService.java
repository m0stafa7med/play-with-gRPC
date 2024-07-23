package com.mostafa.service;


import com.google.protobuf.Empty;
import com.mostafa.models.sec06.AccountBalance;
import com.mostafa.models.sec06.AllAccountsResponse;
import com.mostafa.models.sec06.BalanceCheckRequest;
import com.mostafa.models.sec06.BankServiceGrpc;
import com.mostafa.repository.AccountRepository;
import io.grpc.stub.StreamObserver;

import java.util.List;
import java.util.stream.Collectors;

public class BankService extends BankServiceGrpc.BankServiceImplBase {

    @Override
    public void getAccountBalance(BalanceCheckRequest request,
                                  StreamObserver<AccountBalance> responseObserver) {

        int accountNumber = request.getAccountNumber();
        var balance = AccountRepository.getBalance(accountNumber);
        var accountBalance = AccountBalance.newBuilder()
                .setAccountNumber(accountNumber)
                .setBalance(accountNumber * 10 + balance).build();

        responseObserver.onNext(accountBalance);
        responseObserver.onCompleted();
    }

    @Override
    public void getAllAccounts(Empty request, StreamObserver<AllAccountsResponse> responseObserver) {
        var accounts = AccountRepository.getAllAccounts()
                .entrySet()
                .stream()
                .map(e -> AccountBalance.newBuilder()
                        .setAccountNumber(e.getKey()).setBalance(e.getValue()).build())
                .collect(Collectors.toList());

        var response = AllAccountsResponse.newBuilder().addAllAccounts(accounts).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }
}
