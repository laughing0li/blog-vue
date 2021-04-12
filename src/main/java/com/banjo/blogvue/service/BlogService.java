package com.banjo.blogvue.service;


import com.banjo.blogvue.dao.BlogDAO;
import com.banjo.blogvue.pojo.Blog;
import com.banjo.blogvue.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    BlogDAO blogDAO;

    public Page4Navigator<Blog> list(int start, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(start, size, sort);
        Page<Blog> pageFromJPA = blogDAO.findAll(pageable);
        return new Page4Navigator<>(pageFromJPA);
    }

    public void delete(int id) {
        blogDAO.deleteById(id);
    }

    public Blog get(int id) {
        return blogDAO.getOne(id);
    }

    public void add(Blog blog) {
        blogDAO.save(blog);
    }

    public void update(Blog blog) {
        blogDAO.save(blog);
    }

    public List<Blog> list(int cid) {
        return blogDAO.findByCategory_id(cid);
    }

    public List<Blog> findTop(int size) {
        Pageable pageable = PageRequest.of(0, size, Sort.by(Sort.Direction.DESC, "updateTime"));
        return blogDAO.findTop(pageable);
    }

    public Page4Navigator<Blog> findByCategoryId(int start, int size, int cid) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(start, size, sort);
        Page<Blog> pageFromJPA = blogDAO.findByCategory_id(pageable, cid);
        return new Page4Navigator<>(pageFromJPA);
    }
}
