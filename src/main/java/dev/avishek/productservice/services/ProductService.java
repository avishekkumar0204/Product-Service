package dev.avishek.productservice.services;

import dev.avishek.productservice.dtos.GenricProductDto;

import java.util.List;

public interface ProductService {
    GenricProductDto getProductById(Long id);
    GenricProductDto addProduct(GenricProductDto product);
    List<GenricProductDto> getAllProducts();
    GenricProductDto deleteProductById(Long id);
    GenricProductDto updateProduct(Long id, GenricProductDto product);
}
