package com.mostafa.playwithgrpc;



import com.mostafa.models.Person;

import java.io.IOException;
import java.nio.file.Path;


public class TestPerformance {
    private static final Path PATH = Path.of("person.out");

    public static void main(String[] args) throws IOException {


        Person sam = Person.
                newBuilder()
                .setEmployed(true)
                .build();


    }



}
