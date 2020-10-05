package com.peterpham.myfirstcrud.controllers;

import com.peterpham.myfirstcrud.domain.Supplier;
import com.peterpham.myfirstcrud.repositories.SupplierRepository;
import com.peterpham.myfirstcrud.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @RequestMapping("")
    public String index(Model model){
        List<Supplier> suppliers = supplierService.getAllSupplier();

        model.addAttribute("suppliers", suppliers);

        return "/suppliers/index";
    }

    @RequestMapping(value = "/add")
    public String addSupplier(Model model){
        model.addAttribute("supplier", new Supplier());
        return "/suppliers/addSupplier";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET )
    public String editSupplier(@RequestParam("id") Long supplierId, Model model){
        Optional<Supplier> supplierEdit = supplierService.findSupplierById(supplierId);
        supplierEdit.ifPresent(supplier -> model.addAttribute("supplier", supplier));
        return "/suppliers/editSupplier";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveSupplier(Supplier supplier){
        supplierService.saveSupplier(supplier);
        return "redirect:/suppliers";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteSupplier(@RequestParam("id") Long supplierId, Model model){
        supplierService.deleteSupplier(supplierId);
        return "redirect:/suppliers";
    }
}
