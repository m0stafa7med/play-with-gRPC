package com.mostafa.playwithgrpc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.InvalidProtocolBufferException;
import com.mostafa.json.JPerson;
import com.mostafa.models.Person;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Logger;


public class TestPerformance {
    private static final Path PATH = Path.of("person.out");

    public static void main(String[] args) throws IOException {
/*
        ObjectMapper objectMapper = new ObjectMapper();




        JPerson mostafa = new JPerson();
        mostafa.setAge(26);
        mostafa.setName("mostafa");
        Runnable json = () -> {
            try {
                byte[] bytes = objectMapper.writeValueAsBytes(mostafa);
                JPerson p1 = objectMapper.readValue(bytes, JPerson.class);
                System.out.println(" json bytes length:" + bytes.length);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Person sam = Person.
                newBuilder().setName("sam").setAge(16).build();

        Runnable protopuf = () -> {
            try {
                byte[] bytes = sam.toByteArray();
                Person p2 = Person.parseFrom(bytes);
                System.out.println(" proto bytes length:" + bytes.length);

            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
        };

        runPerformanceTest(json, "JSON");
        runPerformanceTest(protopuf, "PROTOPUF");*/


        Person sam = Person.
                newBuilder()
//                .setName("sam")
//                .setAge(16)
//                .setEmail("mostafa@gmail.com")
                .setEmployed(true)
                .build();


        serialize(sam);
        System.out.println(deserialize());
        System.out.println("equals: " + sam.equals(deserialize()));
        System.out.println("bytes length :" + sam.toByteArray().length);
    }


    public static void runPerformanceTest(Runnable runnable, String method) {
        long time1 = System.currentTimeMillis();
        //for (int i = 0; i < 1_000_000; i++) {
        runnable.run();
        //}
        long time2 = System.currentTimeMillis();
        System.out.print(method + " ");
        System.out.println(time2 - time1);
    }

    public static void serialize(Person person) throws IOException {
        person.writeTo(Files.newOutputStream(PATH));
    }

    public static Person deserialize() throws IOException {
        return Person.parseFrom(Files.newInputStream(PATH));
    }
}
