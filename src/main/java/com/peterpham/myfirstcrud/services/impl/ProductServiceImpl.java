package com.peterpham.myfirstcrud.services.impl;

import com.peterpham.myfirstcrud.domain.Category;
import com.peterpham.myfirstcrud.domain.Product;
import com.peterpham.myfirstcrud.domain.Supplier;
import com.peterpham.myfirstcrud.repositories.CategoryRepository;
import com.peterpham.myfirstcrud.repositories.ProductRepository;
import com.peterpham.myfirstcrud.repositories.SupplierRepository;
import com.peterpham.myfirstcrud.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> listAll(String keyword) {
        if (keyword != null) {
            return productRepository.search(keyword);
        }
        return productRepository.findAll();
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);

    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);

    }

    @Override
    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }
}
