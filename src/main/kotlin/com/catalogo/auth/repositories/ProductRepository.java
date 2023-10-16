package com.catalogo.auth.repositories;

import com.catalogo.auth.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
