package com.hansreidan.store.Prodotti.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    @Getter @Setter
    private String description;
    @Getter @Setter
    private double price;

    public Product(Long id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    public Product() {

    }
}
