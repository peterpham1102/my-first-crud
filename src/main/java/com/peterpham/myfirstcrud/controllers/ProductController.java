package com.peterpham.myfirstcrud.controllers;

import com.peterpham.myfirstcrud.domain.Category;
import com.peterpham.myfirstcrud.domain.Product;
import com.peterpham.myfirstcrud.domain.Supplier;
import com.peterpham.myfirstcrud.repositories.ProductRepository;
import com.peterpham.myfirstcrud.services.CategoryService;
import com.peterpham.myfirstcrud.services.ProductService;
import com.peterpham.myfirstcrud.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SupplierService supplierService;

    @RequestMapping("")
    public String index(Model model){
        List<Product> products = productService.getAllProduct();
//        List<Category> categories = productService.getAllCategory();
//        List<Supplier> suppliers = productService.getAllSupplier();


        model.addAttribute("products", products);
//        model.addAttribute("categories", categories);
//        model.addAttribute("suppliers", suppliers);

        return "products/index";
    }

    @RequestMapping(value = "search")
    public String findProductByName(Model model, @Param("keyword") String keyword){
        List<Product> products = productService.listAll(keyword);
        model.addAttribute("products", products);
        model.addAttribute("keyword", keyword);
        return "products/index";
    }



    @RequestMapping(value = "/add")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());

        return "/products/addProduct";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editProduct(@RequestParam("id") Long productId, Model model){
        Optional<Product> productEdit = productService.findProductById(productId);
        productEdit.ifPresent(product -> model.addAttribute("product", product));

        return "/products/editProduct";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String saveProduct(Product product){
        productService.saveProduct(product);

        return "redirect:/products";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteProduct(@RequestParam("id") Long productId, Model model){
        productService.deleteProduct(productId);

        return "redirect:/products";
    }

//    @RequestMapping(value = "/search")

}
