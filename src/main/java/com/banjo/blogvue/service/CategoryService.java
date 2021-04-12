package com.banjo.blogvue.service;


import com.banjo.blogvue.dao.CategoryDAO;
import com.banjo.blogvue.pojo.Category;
import com.banjo.blogvue.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryService {

    @Autowired
    CategoryDAO categoryDAO;

    public Page4Navigator<Category> list(int start, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(start, size, sort);
        Page<Category> pageFromJPA = categoryDAO.findAll(pageable);
        return new Page4Navigator<>(pageFromJPA);
    }
    public Category getOne(int id) {
        return categoryDAO.getOne(id);
    }

    public void delete(int id) {
        categoryDAO.deleteById(id);
    }

    public void add(Category category) {
        categoryDAO.save(category);
    }


    public List<Category> listTop(int size) {
        Pageable pageable = PageRequest.of(0, size);
        return categoryDAO.findTop(pageable);
    }

    public List<Category> list() {
        return categoryDAO.findAll();
    }
}
