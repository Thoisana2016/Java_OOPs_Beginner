package dev.thoisana.ProductServiceAPI.controllers;

import dev.thoisana.ProductServiceAPI.models.Product;
import dev.thoisana.ProductServiceAPI.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/product/{id}")
    public Product getProductByID(@PathVariable("id") Long id){
        return productService.getSingleProduct(id);
    }
}
