package dev.avishek.productservice.services;

import dev.avishek.productservice.dtos.GenricProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")
public class SelfProductService implements ProductService {
    public GenricProductDto getProductById(Long id) {
        return null;
    }
    public GenricProductDto addProduct(GenricProductDto product) {
        System.out.println("SelfProductService::addProduct");
        return null;
    }
    public List<GenricProductDto> getAllProducts(){
        return null;
    }
    public GenricProductDto deleteProductById(Long id) {
        return null;
    }
    public GenricProductDto updateProduct(Long id, GenricProductDto product) {
        return null;
    }
}
