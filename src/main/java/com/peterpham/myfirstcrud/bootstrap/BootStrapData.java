package com.peterpham.myfirstcrud.bootstrap;

import com.peterpham.myfirstcrud.domain.Category;
import com.peterpham.myfirstcrud.domain.Product;
import com.peterpham.myfirstcrud.domain.Supplier;
import com.peterpham.myfirstcrud.repositories.CategoryRepository;
import com.peterpham.myfirstcrud.repositories.ProductRepository;
import com.peterpham.myfirstcrud.repositories.SupplierRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;

    public BootStrapData(CategoryRepository categoryRepository, ProductRepository productRepository, SupplierRepository supplierRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Supplier sup1 = new Supplier("Nike", "USA");
        Supplier sup2 = new Supplier("Adidas", "USA");

        supplierRepository.save(sup1);
        supplierRepository.save(sup2);

        Category cat1 = new Category("Clothes", "This is clothes category");
        Product pro1 = new Product("Nike shirt", "50$", "This is Nike shirt");

        cat1.getProducts().add(pro1);
        pro1.getCategory().add(cat1);

        pro1.setSupplier(sup1);
        sup1.getProducts().add(pro1);


        categoryRepository.save(cat1);
        productRepository.save(pro1);
        supplierRepository.save(sup1);


        Category cat2 = new Category("Accessories", "This is accessories category");
        Product pro2 = new Product("Adidas necklace", "60$", "This is Adidas shirt");


        cat2.getProducts().add(pro2);
        pro2.getCategory().add(cat2);

        pro2.setSupplier(sup2);
        sup2.getProducts().add(pro2);

        categoryRepository.save(cat2);
        productRepository.save(pro2);
        supplierRepository.save(sup2);

        System.out.println(pro1);
        System.out.println(cat1);
        System.out.println(sup1);



        cat2.getProducts().add(pro2);
        pro2.getCategory().add(cat2);

        pro2.setSupplier(sup2);
        sup2.getProducts().add(pro2);


        categoryRepository.save(cat2);
        productRepository.save(pro2);
        supplierRepository.save(sup2);


    }
}
