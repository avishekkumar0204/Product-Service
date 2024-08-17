package dev.avishek.productservice.controllers;

import dev.avishek.productservice.dtos.GenericProductDto;
import dev.avishek.productservice.models.Product;
import dev.avishek.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")

public class ProductController {
    private ProductService productService;

    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getAllProducts() {
        return "All Products Listing";
    }

    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) {
        GenericProductDto product = productService.getProductById(id);
        System.out.println("ProductController::getProductById: " + product);
        return product;
    }

    @DeleteMapping("{id}")
    public void deleteProductById() {

    }

    @PostMapping
    public String createProduct(){
        return "Adding product";
    }

    @PutMapping("{id}")
    public void updateProductById(){

    }
}
