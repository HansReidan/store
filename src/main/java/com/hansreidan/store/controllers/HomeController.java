package com.hansreidan.store.controllers;

import com.hansreidan.store.domain.Product;
import com.hansreidan.store.domain.ProductListForm;
import com.hansreidan.store.domain.Utente;
import com.hansreidan.store.exceptions.ProductNotFoundException;
import com.hansreidan.store.jpa.ProductRepository;
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

    private final ProductRepository productRepository;

    public HomeController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    List<Product> products = Arrays.asList(
            new Product(1L, "Roblox", 999.99),
            new Product(2L, "Smartphone", 499.99),
            new Product(3L, "Tablet", 299.99)
    );

    @GetMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("products", products);
        return "product_list";
    }

    public Product getFromId(Long id) {
        for (Product p : products) {
            if (p.getId().equals(id)) {
                return new Product(id, p.getDescription(), p.getPrice());
            }
        }
        return null;
    }

    @GetMapping("/products/{id}")
    public String showProduct(@PathVariable Long id, Model model) {
//        Se accedi a /prodotti/42, Spring mette 42 nella variabile id
//        L’annotazione lega la parte dell’URL alla variabile del metodo

        if (id <= 0) {
            throw new ProductNotFoundException("Prodotto non trovato! ID: " + id);
        } else {
            Product product = getFromId(id);

            model.addAttribute("product", product);
            return "product_details";
        }
    }

    @GetMapping("/products/modify")
    public String modifyProduct(Model model) {
        List<Product> products = productRepository.findAll();
        ProductListForm form = new ProductListForm();
        form.setProducts(products);
        model.addAttribute("form", form);
        return "product_modify";
    }

    @PostMapping("/products/modify")
    public String modifyProduct(@ModelAttribute ProductListForm form) {
        productRepository.saveAll(form.getProducts());
        return "redirect:/products";
    }

    @GetMapping("/products/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "add_product";
    }

    @PostMapping("/products")
    public String addProduct(@ModelAttribute Product product) {
        // Legare i dati di un form HTML a un oggetto Java
        // Popolare automaticamente un oggetto da parametri della richiesta
        System.out.println("Aggiunto prodotto: " + product.getDescription());
        return "redirect:/products";
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public String handleException(ProductNotFoundException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error";
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
