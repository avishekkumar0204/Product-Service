package dev.avishek.productservice.services;

import dev.avishek.productservice.dtos.GenericProductDto;
import dev.avishek.productservice.models.Product;
import org.springframework.stereotype.Service;

@Service("selfProductService")
public class SelfProductService implements ProductService {
    public GenericProductDto getProductById(Long id){
        return null;
    }
}
