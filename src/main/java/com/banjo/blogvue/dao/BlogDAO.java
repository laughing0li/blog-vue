package com.banjo.blogvue.dao;

import com.banjo.blogvue.pojo.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BlogDAO extends JpaRepository<Blog, Integer> {

    @Query("select b from Blog b")
    List<Blog> findTop(Pageable pageable);

    Page<Blog> findByCategory_id(Pageable pageable, int id);

    List<Blog> findByCategory_id(int cid);
}
