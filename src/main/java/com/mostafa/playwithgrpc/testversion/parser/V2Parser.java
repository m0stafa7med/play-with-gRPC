package com.mostafa.playwithgrpc.testversion.parser;

import com.google.protobuf.InvalidProtocolBufferException;
import com.mostafa.models.sec05.v2.Television;

public class V2Parser {
    public static void parse(byte[] bytes) throws InvalidProtocolBufferException {
        var tv = Television.parseFrom(bytes);


        System.out.println("v2 brand "+tv.getBrand());
        System.out.println("v2 model " + tv.getModel());
        System.out.println("v2 type " + tv.getType());

    }
}
