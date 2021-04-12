package com.banjo.blogvue.controller.admin;


import com.banjo.blogvue.pojo.Category;
import com.banjo.blogvue.service.BlogService;
import com.banjo.blogvue.service.CategoryService;
import com.banjo.blogvue.util.Page4Navigator;
import com.banjo.blogvue.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin")
public class CategoryController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    BlogService blogService;

    @GetMapping("/categories")
    public Object list(@RequestParam(defaultValue = "0") int start,
                       @RequestParam(defaultValue = "6") int size) {
        start = start < 0 ? 0 : start;
        Page4Navigator<Category> categoryPage = categoryService.list(start, size);
        return Result.success(categoryPage);
    }

    @GetMapping("/categoryList")
    public Object list() {
        return Result.success(categoryService.listTop(999));
    }

    @DeleteMapping("/categories/{id}")
    public Object delete(@PathVariable int id) {
        categoryService.delete(id);
        return null;
    }

    @PostMapping("/categories")
    public Object add(Category category) {
        categoryService.add(category);
        return Result.success(null);
    }


}
