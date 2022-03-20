package com.bai_tap.create_app_blog.service;

import com.bai_tap.create_app_blog.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findAll();

    void save(Category category);

    Category update(Category category);

    Optional<Category> findById(int id);

    void remove(int id);


}
