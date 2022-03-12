package com.bai_tap.create_app_blog.service;

import com.bai_tap.create_app_blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog update(Blog blog);

    Blog findById(int id);

    void remove(int id);


}
