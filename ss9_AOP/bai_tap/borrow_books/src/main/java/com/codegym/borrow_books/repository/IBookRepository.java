package com.codegym.borrow_books.repository;

import com.codegym.borrow_books.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Books, Integer> {
}
