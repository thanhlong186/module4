package com.codegym.borrow_books.service.Impl;

import com.codegym.borrow_books.model.CodeBook;
import com.codegym.borrow_books.repository.ICodeBookRepository;
import com.codegym.borrow_books.service.ICodeBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CodeBookServiceImpl implements ICodeBookService {
    @Autowired
    private ICodeBookRepository codeBookRepository;

    @Override
    public List<CodeBook> findAll() {
        return codeBookRepository.findAll();
    }

    @Override
    public CodeBook save(CodeBook codeBook) {
        codeBookRepository.save(codeBook);
        return codeBook;
    }

    @Override
    public Optional<CodeBook> findById(int id) {
        return codeBookRepository.findById(id);
    }


    @Override
    public CodeBook update(CodeBook codeBook) {
        return codeBookRepository.save(codeBook);
    }

    @Override
    public void remove(int id) {
        codeBookRepository.findById(id);
    }

    @Override
    public CodeBook findByCode(String code) {
        return codeBookRepository.findByCode(code);
    }
}
