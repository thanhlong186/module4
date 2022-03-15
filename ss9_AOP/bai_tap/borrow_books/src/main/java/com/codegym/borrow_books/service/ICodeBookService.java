package com.codegym.borrow_books.service;

import com.codegym.borrow_books.model.CodeBook;

import java.util.List;
import java.util.Optional;

public interface ICodeBookService {
    List<CodeBook> findAll();

    CodeBook save(CodeBook codeBook);

    Optional<CodeBook> findById(int id);

    CodeBook update(CodeBook codeBook);

    void remove(int id);

    CodeBook findByCode(String code);
}
