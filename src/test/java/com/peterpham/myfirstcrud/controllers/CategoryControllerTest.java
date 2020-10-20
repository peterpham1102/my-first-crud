package com.peterpham.myfirstcrud.controllers;

import com.peterpham.myfirstcrud.repositories.CategoryRepository;
import com.peterpham.myfirstcrud.services.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoryControllerTest {

    @Mock
    CategoryService categoryService;

    @Mock
    Model model;

    CategoryController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        controller = new CategoryController(categoryService);

    }

    @Test
    void index() {

        String viewIndex = controller.index(model);
        assertEquals("/categories/index", viewIndex);
        verify(categoryService, times(1)).getAllCategory();
        verify(model, times(1)).addAttribute(eq("categories"), anyList());
    }

    @Test
    void addCategory() {



    }

    @Test
    void editCategory() {
    }

    @Test
    void saveCategory() {
    }

    @Test
    void deleteCategory() {
    }
}