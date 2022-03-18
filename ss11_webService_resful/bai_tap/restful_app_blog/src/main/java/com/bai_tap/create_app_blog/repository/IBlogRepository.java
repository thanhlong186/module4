package com.bai_tap.create_app_blog.repository;

import com.bai_tap.create_app_blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface IBlogRepository extends JpaRepository<Blog, Integer> {


}
