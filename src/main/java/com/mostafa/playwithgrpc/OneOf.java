package com.mostafa.playwithgrpc;

import com.mostafa.models.Credentials;
import com.mostafa.models.Email;
import com.mostafa.models.Phone;

public class OneOf {

    public static void main(String[] args) {
        var email = Email.newBuilder()
                .setAddress("mostafa@gmail.com")
                .setPassword("123").build();
        var phone = Phone.newBuilder()
                .setNumber(123456789)
                .setCode(2)
                .build();

        var credentials = Credentials.newBuilder()
                .setEmail(email)
                .build();
        login(credentials);

    }

    public static void login(Credentials credentials) {

        switch (credentials.getLoginTypeCase()) {
           // case EMAIL -> System.out.println("email -> " + credentials.getEmail());
          //  case PHONE -> System.out.println("phone -> {}" + credentials.getPhone());
        }


    }
}
