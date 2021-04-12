package com.banjo.blogvue.controller.admin;

import com.banjo.blogvue.pojo.Blog;
import com.banjo.blogvue.pojo.Category;
import com.banjo.blogvue.pojo.User;
import com.banjo.blogvue.service.BlogService;
import com.banjo.blogvue.service.CategoryService;
import com.banjo.blogvue.service.UserService;
import com.banjo.blogvue.util.MyBeanUtils;
import com.banjo.blogvue.util.Page4Navigator;
import com.banjo.blogvue.util.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    BlogService blogService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    UserService userService;

    @GetMapping("/blogs")
    public Object list(@RequestParam(defaultValue = "0") int start,
                       @RequestParam(defaultValue = "6") int size){
        start = start < 0 ? 0 : start;
        Page4Navigator<Blog> blogPage = blogService.list(start, size);
        return Result.success(blogPage);
    }

    @GetMapping("/blogs/{id}")
    public Object get(@PathVariable int id) {
        Blog blog = blogService.get(id);
        return Result.success(blog);
    }

    @PostMapping("/blogs")
    public Object add(Blog blog) throws Exception {
        blog.setCreateTime(new Date());
        Category category = categoryService.getOne(blog.getCategory_id());
        User user = userService.getOne(blog.getUser_id());
        blog.setUser(user);
        blog.setCategory(category);
        blogService.add(blog);
        return Result.success(null);
    }

    @PutMapping("/blogs")
    public Object update(Blog blog) {
        Blog b = blogService.get(blog.getId());
        Category category = categoryService.getOne(blog.getCategory_id());
        blog.setCategory(category);
        blog.setUpdateTime(new Date());
        BeanUtils.copyProperties(blog, b, MyBeanUtils.getNullPropertyNames(blog));
        blogService.update(b);
        return null;
    }

    @DeleteMapping("/blogs/{id}")
    public Object delete(@PathVariable int id) {
        blogService.delete(id);
        return null;
    }

}
