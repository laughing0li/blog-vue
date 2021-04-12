package com.banjo.blogvue;

import com.banjo.blogvue.pojo.Blog;
import com.banjo.blogvue.pojo.Category;
import com.banjo.blogvue.service.BlogService;
import com.banjo.blogvue.service.CategoryService;
import com.banjo.blogvue.util.Page4Navigator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.List;

@SpringBootTest
class BlogVueApplicationTests {

    @Autowired
    CategoryService categoryService;
    @Autowired
    BlogService blogService;

    @Test
    void contextLoads() {
    }

    @Test
    @Transactional
    void testBlog() {
        Page4Navigator<Blog> blogPage = blogService.findByCategoryId(0, 2, 1);
        System.out.println(blogPage.getContent());
    }


}
