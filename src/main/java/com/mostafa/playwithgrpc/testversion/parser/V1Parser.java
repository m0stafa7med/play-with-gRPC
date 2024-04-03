package com.mostafa.playwithgrpc.testversion.parser;

import com.google.protobuf.InvalidProtocolBufferException;
import com.mostafa.models.sec05.v1.Television;

public class V1Parser {
    public static void parse(byte[] bytes) throws InvalidProtocolBufferException {
        var tv = Television.parseFrom(bytes);

        System.out.println("v1 brand "+tv.getBrand());
        System.out.println("v1 year " + tv.getYear());
        System.out.println("v1 age " + tv.getAge());

    }
}
