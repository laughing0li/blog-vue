package com.banjo.blogvue.dao;

import com.banjo.blogvue.pojo.Category;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryDAO extends JpaRepository<Category, Integer> {

    Category findByName(String name);


    @Query("select c from Category c")

    List<Category> findTop(Pageable pageable);

}
