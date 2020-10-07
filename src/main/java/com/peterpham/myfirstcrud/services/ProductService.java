package com.peterpham.myfirstcrud.services;



import com.peterpham.myfirstcrud.domain.Category;
import com.peterpham.myfirstcrud.domain.Product;
import com.peterpham.myfirstcrud.domain.Supplier;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProduct();
//    List<Category> getAllCategory();
//    List<Supplier> getAllSupplier();
    List<Product> listAll(String keyword);

    void saveProduct(Product product);

    void deleteProduct(Long id);

    Optional<Product> findProductById(Long id);


}
