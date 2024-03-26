package com.mostafa.playwithgrpc;


import com.mostafa.models.BodyStyle;
import com.mostafa.models.Car;
import com.mostafa.models.Dealer;
import com.mostafa.models.School;

import java.io.IOException;


public class PersonDemo {
    public static void main(String[] args)  {
        var car1 = Car.newBuilder().setMake("honda")
                .setModel("civic")
                .setYear(2000)
                .build();

        var car2 = Car.newBuilder().setMake("honda")
                .setModel("accord")
                .setYear(2002)
                .setBodyStyle(BodyStyle.COUPE)
                .build();


        System.out.println(car2);

     /*   var dealer = Dealer.newBuilder()
                .putInventory(car1.getYear(), car1)
                .putInventory(car2.getYear(), car2);

        System.out.println(dealer);
*/


    }
}
