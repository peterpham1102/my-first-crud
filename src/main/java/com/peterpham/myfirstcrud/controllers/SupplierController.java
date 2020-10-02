package com.peterpham.myfirstcrud.controllers;

import com.peterpham.myfirstcrud.repositories.SupplierRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SupplierController {
    private final SupplierRepository supplierRepository;

    public SupplierController(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @RequestMapping("/suppliers")
    public String getSuppliers(Model model){
        model.addAttribute("suppliers", supplierRepository.findAll());

        return "suppliers/list";
    }
}
