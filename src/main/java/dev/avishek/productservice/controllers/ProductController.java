package dev.avishek.productservice.controllers;

import dev.avishek.productservice.dtos.GenricProductDto;
import dev.avishek.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public GenricProductDto getProductById(@PathVariable("id") Long id) {
        System.out.println("ProductController::getProductById");
        return productService.getProductById(id);
    }

    @PostMapping
    public GenricProductDto addProduct(@RequestBody GenricProductDto product) {
        System.out.println("ProductController::addProduct");
        return productService.addProduct(product);
    }

    @GetMapping
    public List<GenricProductDto> getAllProducts() {
        System.out.println("ProductController::getAllProducts");
        return productService.getAllProducts();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<GenricProductDto> deleteProductById(@PathVariable("id") Long id) {
        System.out.println("ProductController::deleteProductById");
        ResponseEntity<GenricProductDto> response = new ResponseEntity<>(productService.deleteProductById(id), HttpStatus.NOT_FOUND);
        return response;
    }

    @PatchMapping("{id}")
    public GenricProductDto updateProduct(@PathVariable("id") Long id, @RequestBody GenricProductDto product) {
        System.out.println("ProductController::updateProduct");
        return productService.updateProduct(id, product);
    }
}
