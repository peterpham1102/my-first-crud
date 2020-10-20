package com.peterpham.myfirstcrud.services.impl;

import com.peterpham.myfirstcrud.domain.Category;
import com.peterpham.myfirstcrud.repositories.CategoryRepository;
import com.peterpham.myfirstcrud.services.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoryServiceImplTest {

    CategoryServiceImpl categoryService;

    @Mock
    CategoryRepository categoryRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        categoryService = new CategoryServiceImpl(categoryRepository);



    }

    @Test
    void getAllCategory() {

        Category category = new Category();
        ArrayList categoriesData = new ArrayList();
        categoriesData.add(category);

        when(categoryRepository.findAll()).thenReturn(categoriesData);

        List<Category> categories = categoryService.getAllCategory();

        assertEquals(categories.size(), 1);
        verify(categoryRepository, times(1)).findAll();
    }

    @Test
    void saveCategory() {
    }

    @Test
    void deleteCategory() {
    }

    @Test
    void findCategoryById() {
    }
}