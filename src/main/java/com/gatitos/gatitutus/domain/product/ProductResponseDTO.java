package com.gatitos.gatitutus.domain.product;

public record ProductResponseDTO(Long id, String name, Float price) {
    public ProductResponseDTO(Product product) {
        this(product.getId(), product.getName(), product.getPrice());
    }
}
