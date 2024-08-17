package dev.avishek.productservice.services;

import dev.avishek.productservice.dtos.FakeStoreProductDto;
import dev.avishek.productservice.dtos.GenericProductDto;
import dev.avishek.productservice.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("fakeStoreProductService")

public class FakeStoreProductService implements ProductService {
    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public GenericProductDto getProductById(Long id){
        System.out.println("FakeStoreProductService::getProductById");
        RestTemplate restTemplate = restTemplateBuilder.build();
        String requestUrl = "https://fakestoreapi.com/products/{id}";
        ResponseEntity<GenericProductDto> response  = restTemplate.getForEntity(requestUrl, GenericProductDto.class, id);
        GenericProductDto product = response.getBody();
        return product;
    }

    public GenericProductDto createProduct(GenericProductDto product){
        System.out.println("FakeStoreProductService::createProduct");
        RestTemplate restTemplate = restTemplateBuilder.build();
        String requestUrl = "https://fakestoreapi.com/products";
        ResponseEntity<GenericProductDto> response = restTemplate.postForEntity(requestUrl, product, GenericProductDto.class);

        return response.getBody();
    }
}
