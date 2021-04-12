package com.banjo.blogvue.controller.fore;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForePageController {

    @GetMapping("/")
    public String index() {
        return "fore/index";
    }

    @GetMapping("/listCategories")
    public String categories() {
        return "fore/categories";
    }

    @GetMapping("/blog")
    public String blogDetail() {
        return "fore/blog";
    }
}
