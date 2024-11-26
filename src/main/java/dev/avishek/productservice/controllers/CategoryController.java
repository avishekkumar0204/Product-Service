package dev.avishek.productservice.controllers;

import dev.avishek.productservice.exceptions.NotFoundException;
import dev.avishek.productservice.models.Category;
import dev.avishek.productservice.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping("/{uuid}")
    public Category getCategory(@PathVariable("uuid") String uuid) throws NotFoundException {
        System.out.println(uuid);
        return categoryService.getCategory(uuid);
    }
}
