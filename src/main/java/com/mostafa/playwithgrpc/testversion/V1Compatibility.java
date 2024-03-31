package com.mostafa.playwithgrpc.testversion;

import com.google.protobuf.InvalidProtocolBufferException;
import com.mostafa.models.sec05.v1.Television;
import com.mostafa.playwithgrpc.testversion.parser.V1Parser;

public class V1Compatibility {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        var tv = Television.newBuilder().setBrand("samsung")
                .setYear(2011)
                .build();

        V1Parser.parse(tv.toByteArray());
    }
}
