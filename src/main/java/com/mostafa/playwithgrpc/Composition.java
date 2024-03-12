package com.mostafa.playwithgrpc;

import com.mostafa.models.Address;
import com.mostafa.models.School;
import com.mostafa.models.Student;


public class Composition {

    public static void main(String[] args) {
        var address = Address.newBuilder()
                .setStreet("main st.")
                .setCity("atlanta")
                .setState("GA")
                .build();

        var student = Student.newBuilder()
                .setAddress(address)
                .setName("mostafa")
                .build();


        var school = School.newBuilder()
                .setId(1)
                .setName("shoubra el kawmya")
                .setAddress(address.toBuilder().setStreet("shoubra"))
                .build();


        System.out.println(student);

        System.out.println(school);
    }
}
