package com.mostafa.common;

import io.grpc.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class GrpcServer {
    private final Server server;

    private GrpcServer(Server server) {
        this.server = server;
    }


    public static GrpcServer create(BindableService... services) {
        return create(6565, services);
    }

    public static GrpcServer create(int port, BindableService... services) {
        var builder = ServerBuilder.forPort(port);
        Arrays.asList(services).forEach(builder::addService);

        return new GrpcServer(builder.build());
    }

    public GrpcServer start() {
        var services = server.getServices()
                .stream()
                .map(ServerServiceDefinition::getServiceDescriptor)
                .map(ServiceDescriptor::getName)
                .collect(Collectors.toList());

        try {
            server.start();
            System.out.println("service started. on port " + server.getPort() + " services " + services);
            return this;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void await() {
        try {
            server.awaitTermination();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void stop() {
        server.shutdownNow();
        System.out.println("server stopped");
    }


}
