package com.mostafa.test.sec06;

import com.mostafa.common.GrpcServer;
import com.mostafa.models.sec06.BankServiceGrpc;
import com.mostafa.service.BankService;
import com.mostafa.test.common.AbstractChannelTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.util.concurrent.TimeUnit;

public abstract class AbstractTest extends AbstractChannelTest {

    private final GrpcServer grpcServer = GrpcServer.create(new BankService());
    protected BankServiceGrpc.BankServiceStub stub;
    protected BankServiceGrpc.BankServiceBlockingStub blockingStub;

    @BeforeAll
    public void setup() {
        this.grpcServer.start();
        this.stub = BankServiceGrpc.newStub(channel);
        this.blockingStub = BankServiceGrpc.newBlockingStub(channel);
    }


    @AfterAll
    public void stop() {
        this.grpcServer.stop();
    }
}
