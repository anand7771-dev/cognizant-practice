package com.library.controller;

import com.library.service.BookService;

public class BookController {

    private BookService service = new BookService();

    public void showBooks() {
        service.displayBooks();
        System.out.println("Book Controller Executed.");
    }

}