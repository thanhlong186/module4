package com.bai_tap.create_app_blog.service.Impl;

import com.bai_tap.create_app_blog.model.Blog;
import com.bai_tap.create_app_blog.repository.IBlogRepository;
import com.bai_tap.create_app_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;


    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog update(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).get();
    }


    @Override
    public void remove(int id) {
        blogRepository.deleteById(id);
    }
}
