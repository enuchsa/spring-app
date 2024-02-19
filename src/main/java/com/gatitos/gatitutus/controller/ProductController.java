package com.gatitos.gatitutus.controller;

import com.gatitos.gatitutus.domain.product.Product;
import com.gatitos.gatitutus.domain.product.ProductRequestDTO;
import com.gatitos.gatitutus.domain.product.ProductResponseDTO;
import com.gatitos.gatitutus.repositories.ProductRepository;
import org.springframework.http.ResponseEntity;
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

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable Long id, @RequestBody ProductRequestDTO productRequestDTO) {
        Product product = new Product(productRequestDTO);
        product.setId(id);
        return ResponseEntity.ok().body(new ProductResponseDTO(productRepository.saveAndFlush(product)));
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getOne(@PathVariable Long id) {
        Product product = productRepository.findById(id).orElse(null);
        ProductResponseDTO productResponseDTO = new ProductResponseDTO(product);
        return ResponseEntity.ok().body(productResponseDTO);
    }

    @GetMapping
    public List<ProductResponseDTO> getAll() {
        return productRepository.findAll().stream().map(ProductResponseDTO::new).toList();
    }
}
