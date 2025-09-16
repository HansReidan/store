package com.hansreidan.store.domain;

import lombok.Getter;
import lombok.Setter;

public class Product {
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

}
