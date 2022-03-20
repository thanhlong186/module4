package com.bai_tap.create_app_blog.repository;

import com.bai_tap.create_app_blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
