package com.banjo.blogvue.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminPageController {

    @GetMapping()
    public String login() {
        return "admin/login";
    }

    @GetMapping("/blog")
    public String listBlogs() {
        return "admin/listBlogs";
    }

    @GetMapping("/blog_add")
    public String addBlog() {
        return "admin/addBlog";
    }

    @GetMapping("/blog_edit")
    public String editBlog() {
        return "admin/editBlog";
    }

    @GetMapping("/category")
    public String listCategories() {
        return "admin/listCategories";
    }
}
