package com.codegym.borrow_books.service.Impl;

import com.codegym.borrow_books.model.Books;
import com.codegym.borrow_books.repository.IBookRepository;
import com.codegym.borrow_books.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<Books> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void save(Books books) {
        bookRepository.save(books);
    }

    @Override
    public Books findById(int id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public Books update(Books books) {
        return bookRepository.save(books);
    }

    @Override
    public void remove(int id) {
        bookRepository.findById(id).get();

    }
}
