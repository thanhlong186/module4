package com.codegym.service;


import com.codegym.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void save(Category category);

    Category update(Category category);

    Category findById(Long id);

    void remove(Long id);


}
