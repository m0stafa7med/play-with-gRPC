package com.mostafa.playwithgrpc;


import com.mostafa.models.common.BodyStyle;
import com.mostafa.models.common.Car;

public class PersonDemo {
    public static void main(String[] args)  {

        var car2 = Car.newBuilder().setMake("honda")
                .setModel("accord")
                .setYear(2002)
                .setBodyStyle(BodyStyle.COUPE)
                .build();

        System.out.println(car2);

    }
}
