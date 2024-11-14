package dev.avishek.productservice.services;

import dev.avishek.productservice.dtos.FakeStoreProductDto;
import dev.avishek.productservice.dtos.GenricProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private RestTemplateBuilder restTemplateBuilder;
    private String specificProductRequestUrl = "https://fakestoreapi.com/products/{id}";
    private String productRequestBaseUrl = "https://fakestoreapi.com/products";

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    private GenricProductDto convertFakeStoreProductDtoToGenricProductDto(FakeStoreProductDto fakeStoreProductDto) {
        GenricProductDto product = new GenricProductDto();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImage(fakeStoreProductDto.getImage());
        product.setCategory(fakeStoreProductDto.getCategory());
        return product;
    }

    public GenricProductDto getProductById(Long id ){
        System.out.println("FakeStoreProductService::getProductById");
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(specificProductRequestUrl, FakeStoreProductDto.class, id);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();
        return convertFakeStoreProductDtoToGenricProductDto(fakeStoreProductDto);
    }

    public GenricProductDto addProduct(GenricProductDto product){
        System.out.println("FakeStoreProductService::addProduct");
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenricProductDto> response =  restTemplate.postForEntity(productRequestBaseUrl, product, GenricProductDto.class);
        return response.getBody();
    }

    public List<GenricProductDto> getAllProducts(){
        System.out.println("FakeStoreProductService::getAllProducts");
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(productRequestBaseUrl, FakeStoreProductDto[].class);
        List<GenricProductDto> answer = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : response.getBody()){
            answer.add(convertFakeStoreProductDtoToGenricProductDto(fakeStoreProductDto));
        }
        return answer;
    }

    public GenricProductDto deleteProductById(Long id){
        System.out.println("FakeStoreProductService::deleteProductById");
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(GenricProductDto.class);
        ResponseExtractor<ResponseEntity<GenricProductDto>> responseExtractor = restTemplate.responseEntityExtractor(GenricProductDto.class);
        ResponseEntity<GenricProductDto> response = restTemplate.execute(specificProductRequestUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);
        return response.getBody();
    }

    public GenricProductDto updateProduct(Long id, GenricProductDto product){
        System.out.println("FakeStoreProductService::updateProduct");
        RestTemplate restTemplate = restTemplateBuilder.build();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<GenricProductDto> requestEntity = new HttpEntity<>(product,headers);
        ResponseEntity<FakeStoreProductDto> response = restTemplate.exchange(specificProductRequestUrl, HttpMethod.PUT,requestEntity,FakeStoreProductDto.class, id);
        return convertFakeStoreProductDtoToGenricProductDto(response.getBody());
    }
}
