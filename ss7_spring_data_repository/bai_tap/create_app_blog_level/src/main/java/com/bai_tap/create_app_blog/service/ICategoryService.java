package com.bai_tap.create_app_blog.service;

import com.bai_tap.create_app_blog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void save(Category category);

    Category update(Category category);

    Category findById(int id);

    void remove(int id);


}
