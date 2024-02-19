package com.gatitos.gatitutus.repositories;

import com.gatitos.gatitutus.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
