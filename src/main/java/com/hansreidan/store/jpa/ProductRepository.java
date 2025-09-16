package com.hansreidan.store.jpa;

import com.hansreidan.store.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
