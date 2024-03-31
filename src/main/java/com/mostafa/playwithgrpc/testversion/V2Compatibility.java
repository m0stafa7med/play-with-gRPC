package com.mostafa.playwithgrpc.testversion;

import com.google.protobuf.InvalidProtocolBufferException;
import com.mostafa.models.sec05.v2.Television;
import com.mostafa.models.sec05.v2.Type;


public class V2Compatibility {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        var tv = Television.newBuilder()
                .setBrand("samsung")
                .setModel(2024)
                .setType(Type.OLED)
                .build();

        System.out.println("");
    }
}
