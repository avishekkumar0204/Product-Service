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
        RestTemplate restTemplate = restTemplateBuilder.build();
        String requestUrl = "https://fakestoreapi.com/products/{id}";
        ResponseEntity<FakeStoreProductDto> response  = restTemplate.getForEntity(requestUrl, FakeStoreProductDto.class, id);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        GenericProductDto product = new GenericProductDto();
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());

        return product;
    }
}
