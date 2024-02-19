package com.gatitos.gatitutus.controller;

import com.gatitos.gatitutus.domain.product.Product;
import com.gatitos.gatitutus.repositories.ProductRepository;
import com.gatitos.gatitutus.domain.product.ProductRequestDTO;
import com.gatitos.gatitutus.domain.product.ProductResponseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public void saveProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        Product product = new Product(productRequestDTO);
        productRepository.save(product);
    }

    @GetMapping
    public List<ProductResponseDTO> getAll() {
        return productRepository.findAll().stream().map(ProductResponseDTO::new).toList();
    }
}
