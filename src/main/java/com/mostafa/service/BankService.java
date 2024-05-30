package com.mostafa.service;


import com.mostafa.models.sec06.AccountBalance;
import com.mostafa.models.sec06.BalanceCheckRequest;
import com.mostafa.models.sec06.BankServiceGrpc;
import com.mostafa.repository.AccountRepository;
import io.grpc.stub.StreamObserver;

public class BankService extends BankServiceGrpc.BankServiceImplBase {

    @Override
    public void getAccountBalance(BalanceCheckRequest request,
                                  StreamObserver<AccountBalance> responseObserver) {

        int accountNumber = request.getAccountNumber();
        var account = AccountRepository.getBalance(accountNumber);
        var accountBalance = AccountBalance.newBuilder()
                .setAccountNumber(accountNumber)
                .setBalance(accountNumber * 10).build();

        responseObserver.onNext(accountBalance);
        responseObserver.onCompleted();
    }
}
