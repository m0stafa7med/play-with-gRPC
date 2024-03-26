package com.mostafa.playwithgrpc;

import com.google.protobuf.Int32Value;
import com.google.protobuf.Timestamp;
import com.mostafa.models.Sample;

import java.time.Instant;

public class SampleTest {
    public static void main(String[] args) {
        var sample = Sample.newBuilder()
                .setAge(Int32Value.of(26))
                .setLoginTime(Timestamp.newBuilder().setSeconds(Instant.now().getEpochSecond()).build())
                .build();


        System.out.println(Instant.ofEpochSecond(sample.getLoginTime().getSeconds()));

    }
}
