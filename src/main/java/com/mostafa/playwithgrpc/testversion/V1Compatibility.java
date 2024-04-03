package com.mostafa.playwithgrpc.testversion;

import com.google.protobuf.InvalidProtocolBufferException;
import com.mostafa.models.sec05.v2.Television;
import com.mostafa.models.sec05.v2.Type;
import com.mostafa.playwithgrpc.testversion.parser.V1Parser;
import com.mostafa.playwithgrpc.testversion.parser.V2Parser;

public class V1Compatibility {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        var tv = Television.newBuilder().setBrand("samsung")
                .setBrand("samsung")
                .setModel(2019)
                .setType(Type.UHD)
                .build();

        V1Parser.parse(tv.toByteArray());
        V2Parser.parse(tv.toByteArray());
    }
}
