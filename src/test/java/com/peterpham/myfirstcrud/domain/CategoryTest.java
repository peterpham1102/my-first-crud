package com.peterpham.myfirstcrud.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    Category category;

    @BeforeEach
    public void setUp(){
        category = new Category();

    }

    @Test
    void getId() {
        Long idValue = 4L;
        category.setId(idValue);

        assertEquals(idValue, category.getId());

    }

    @Test
    void getName() {
        String nameValue = "lmao";
        category.setName(nameValue);

        assertEquals(nameValue, category.getName());

    }

    @Test
    void getDescription() {
        String desValue = "This is test description";
        category.setDescription(desValue);

        assertEquals(desValue, category.getDescription());
    }
}