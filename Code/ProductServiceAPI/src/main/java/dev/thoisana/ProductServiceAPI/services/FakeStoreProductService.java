package dev.thoisana.ProductServiceAPI.services;

import dev.thoisana.ProductServiceAPI.dtos.FakeStoreProductDto;
import dev.thoisana.ProductServiceAPI.models.Category;
import dev.thoisana.ProductServiceAPI.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class FakeStoreProductService implements ProductService{

    @Override
    public Product getSingleProduct(Long id) {
        RestTemplate restTemplate = new RestTemplate();

        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDto.class);

        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImageUrl(fakeStoreProductDto.getImage());

        Category category = new Category();
        category.setTitle(fakeStoreProductDto.getCategory());
        product.setCategory(category);

        return product;
    }
}
