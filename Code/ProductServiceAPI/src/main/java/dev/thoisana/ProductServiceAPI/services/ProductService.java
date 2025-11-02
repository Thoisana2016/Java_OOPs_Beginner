package dev.thoisana.ProductServiceAPI.services;

import dev.thoisana.ProductServiceAPI.models.Product;

public interface ProductService {
    public Product getSingleProduct(Long id);
}
