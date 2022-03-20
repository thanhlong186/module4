package com.bai_tap.create_app_blog.service.Impl;

import com.bai_tap.create_app_blog.model.Category;
import com.bai_tap.create_app_blog.repository.ICategoryRepository;
import com.bai_tap.create_app_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
            categoryRepository.save(category);
    }

    @Override
    public Category update(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Optional<Category> findById(int id) {

        return categoryRepository.findById(id);
    }

    @Override
    public void remove(int id) {
        categoryRepository.deleteById(id);
    }
}
