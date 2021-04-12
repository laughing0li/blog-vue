package com.banjo.blogvue.controller.fore;


import com.banjo.blogvue.pojo.Blog;
import com.banjo.blogvue.pojo.Category;
import com.banjo.blogvue.service.BlogService;
import com.banjo.blogvue.service.CategoryService;
import com.banjo.blogvue.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ForeCategoryController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    BlogService blogService;

    @GetMapping("/categories")
    public Object list() {
        List<Category> categories = categoryService.listTop(6);
        for (Category c : categories) {
            List<Blog> blogs = blogService.list(c.getId());
            c.setTotalBlogs(blogs.size());
        }
        return Result.success(categories);
    }

    @GetMapping("/listCategory")
    public Object listCategory() {
        List<Category> categories = categoryService.listTop(999);
        for (Category c : categories) {
            List<Blog> blogs = blogService.list(c.getId());
            c.setTotalBlogs(blogs.size());
        }
        return Result.success(categories);
    }

}
