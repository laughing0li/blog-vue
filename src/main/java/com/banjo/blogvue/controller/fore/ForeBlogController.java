package com.banjo.blogvue.controller.fore;

import com.banjo.blogvue.pojo.Blog;
import com.banjo.blogvue.service.BlogService;
import com.banjo.blogvue.util.MarkDownUtil;
import com.banjo.blogvue.util.Page4Navigator;
import com.banjo.blogvue.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ForeBlogController {

    @Autowired
    BlogService blogService;


    @GetMapping("/blogs")
    public Object list(@RequestParam(defaultValue = "0") int start,
                       @RequestParam(defaultValue = "6") int size){
        start = start < 0 ? 0 : start;
        Page4Navigator<Blog> blogPage = blogService.list(start, size);
        return Result.success(blogPage);
    }

    @GetMapping("/blogTop")
    public Object blogTop() {
        List<Blog> list = blogService.findTop(4);
        return Result.success(list);
    }

    @GetMapping("/blog/{id}")
    public Object blog(@PathVariable int id) {
        Blog blog = blogService.get(id);
        blog.setContent(MarkDownUtil.markdownToHtmlExtensions(blog.getContent()));
        return Result.success(blog);
    }

    @GetMapping("/blog/cid/{cid}")
    public Object listByCategoryId(@RequestParam(defaultValue = "0") int start,
                                   @RequestParam(defaultValue = "6") int size,
                                   @PathVariable int cid){
        start = start < 0 ? 0 : start;
        Page4Navigator<Blog> blogPage = blogService.findByCategoryId(start, size, cid);
        return Result.success(blogPage);
    }
}
