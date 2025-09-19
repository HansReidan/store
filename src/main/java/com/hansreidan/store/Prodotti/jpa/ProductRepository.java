package com.hansreidan.store.Prodotti.jpa;

import com.hansreidan.store.Prodotti.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
