package dev.avishek.productservice.services;

import dev.avishek.productservice.dtos.GenricProductDto;
import dev.avishek.productservice.exceptions.NotFoundException;

import java.util.List;

public interface ProductService {
    GenricProductDto getProductById(Long id) throws NotFoundException;
    GenricProductDto addProduct(GenricProductDto product);
    List<GenricProductDto> getAllProducts();
    GenricProductDto deleteProductById(Long id);
    GenricProductDto updateProduct(Long id, GenricProductDto product);
}
