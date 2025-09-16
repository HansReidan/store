package com.hansreidan.store.controllers;

import com.hansreidan.store.domain.Product;
import com.hansreidan.store.domain.Utente;
import com.hansreidan.store.jpa.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {
//    @Value("spring.application.name")
//    private String homeName;
//
//    @RequestMapping("/")
//    public String index() {
//        System.out.println(homeName);
//        return "index.html";
//    }

    @GetMapping("/products")
    public String listProducts(Model model) {
        List<Product> products = Arrays.asList(
                new Product(1L, "Laptop", 999.99),
                new Product(2L, "Smartphone", 499.99),
                new Product(3L, "Tablet", 299.99)
        );

        model.addAttribute("products", products);
        return "product_list";
    }

    @GetMapping("/products/{id}")
    public String showProduct(@PathVariable Long id, Model model) {
        Product product = new Product(id, "Prodotto " + id, 100.0 + id);

        model.addAttribute("product", product);
        return "product_details";
    }

//    @Autowired
//    private UtenteRepository utenteRepository;
//    @GetMapping
//    public List<Utente> getAllUtenti() {
//        return utenteRepository.findAll();
//    }
//    @PostMapping
//    public Utente createUtente(@RequestBody Utente utente) {
//        return utenteRepository.save(utente);
//    }
}
