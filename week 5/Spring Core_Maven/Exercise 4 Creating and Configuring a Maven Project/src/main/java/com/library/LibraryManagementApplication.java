package com.library;

import com.library.controller.BookController;

public class LibraryManagementApplication {

    public static void main(String[] args) {

        BookController controller = new BookController();

        controller.showBooks();

    }

}