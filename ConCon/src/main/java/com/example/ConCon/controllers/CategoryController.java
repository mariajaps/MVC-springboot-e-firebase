package com.example.ConCon.controllers;

import com.example.ConCon.model.Category;
import com.example.ConCon.model.User;
import com.example.ConCon.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
@RestController
@Controller
@CrossOrigin(origins = "*")

public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
            this.categoryService = categoryService;
    }

    @GetMapping("/category")
    public List<Category> getAll()throws ExecutionException, InterruptedException {
        return categoryService.getCategory();
    }
    @PostMapping("/createC")
    public String create(@Valid @RequestBody Category category , BindingResult bindingResult ) throws ExecutionException, InterruptedException {
        if (bindingResult.hasErrors()) {

            System.out.println("error");
            return "Error";
        }
        else {
            System.out.println();
            System.out.println(category);
            return categoryService.createCategory(category);
        }

    }
    @DeleteMapping("/deleteC")
    public String deleteCategory(@RequestBody String nomeCategory) throws ExecutionException, InterruptedException {
        return categoryService.deleteCategory(nomeCategory);
    }
    @PutMapping("/alterarC")
    public String updateCategory(@RequestBody Category category) throws ExecutionException, InterruptedException {
        return categoryService.updateCategory(category);
    }
}



