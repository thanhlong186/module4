package com.bai_tap.create_app_blog.service;

import com.bai_tap.create_app_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    void save(Blog blog);

    Blog update(Blog blog);

    Blog findById(int id);

    void remove(int id);


}
