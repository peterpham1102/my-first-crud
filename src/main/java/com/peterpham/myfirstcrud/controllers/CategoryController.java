package com.peterpham.myfirstcrud.controllers;

import com.peterpham.myfirstcrud.domain.Category;
import com.peterpham.myfirstcrud.repositories.CategoryRepository;
import com.peterpham.myfirstcrud.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("")
    public String index(Model model){
        List<Category> categories = categoryService.getAllCategory();

        model.addAttribute("categories", categories);

        return "/categories/index";
    }

    @RequestMapping(value = "/add")
    public String addCategory(Model model){
        model.addAttribute("category", new Category());
        return "/categories/addCategory";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editCategory(@RequestParam("id") Long categoryId, Model model){
        Optional<Category> categoryEdit = categoryService.findCategoryById(categoryId);
        categoryEdit.ifPresent(category -> model.addAttribute("category", category));
        return "/categories/editCategory";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String saveCategory(Category category){
        categoryService.saveCategory(category);
        return "redirect:/categories";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteCategory(@RequestParam("id") Long categoryId, Model model){
        categoryService.deleteCategory(categoryId);
        return "redirect:/categories";
    }


}
