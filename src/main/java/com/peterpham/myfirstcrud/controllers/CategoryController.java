package com.peterpham.myfirstcrud.controllers;

import com.peterpham.myfirstcrud.repositories.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping("/categories")
    public String getCategories(Model model){
        model.addAttribute("categories", categoryRepository.findAll());

        return "categories/list";
    }
}
