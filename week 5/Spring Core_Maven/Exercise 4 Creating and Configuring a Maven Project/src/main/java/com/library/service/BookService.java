package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository repository = new BookRepository();

    public void displayBooks() {
        repository.getBooks();
        System.out.println("Book Service Executed.");
    }

}