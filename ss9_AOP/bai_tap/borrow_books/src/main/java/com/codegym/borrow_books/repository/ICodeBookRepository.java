package com.codegym.borrow_books.repository;

import com.codegym.borrow_books.model.CodeBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICodeBookRepository extends JpaRepository<CodeBook, Integer> {
   CodeBook findByCode(String code);
}
