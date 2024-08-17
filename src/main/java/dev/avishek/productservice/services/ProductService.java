package dev.avishek.productservice.services;

import dev.avishek.productservice.dtos.GenericProductDto;
import dev.avishek.productservice.models.Product;

public interface ProductService {
    GenericProductDto getProductById(Long id);
}
