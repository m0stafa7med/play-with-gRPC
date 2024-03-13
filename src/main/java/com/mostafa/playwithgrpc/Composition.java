package com.mostafa.playwithgrpc;


import com.mostafa.models.Book;
import com.mostafa.models.Library;

import java.util.List;

public class Composition {

    public static void main(String[] args) {
        var book1 = Book.newBuilder()
                .setTitle("harry potter 1")
                .setAuthor("darwesh")
                .setPublicationYear(1997)
                .build();


        var book2 = Book.newBuilder()
                .setTitle("harry potter 2")
                .setAuthor("mostafa")
                .setPublicationYear(1998)
                .build();


        var library = Library.newBuilder()
                .setName("fantasy library")
                .addAllBooks(List.of(book1,book2))
                .build();

        System.out.println(library);
    }
}
