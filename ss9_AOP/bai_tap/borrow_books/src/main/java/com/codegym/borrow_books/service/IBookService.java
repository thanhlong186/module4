package com.codegym.borrow_books.service;

import com.codegym.borrow_books.model.Books;

import java.util.List;

public interface IBookService {
    List<Books> findAll();

    void save(Books books);

    Books findById(int id);

    Books update(Books books);

    void remove(int id);

}
