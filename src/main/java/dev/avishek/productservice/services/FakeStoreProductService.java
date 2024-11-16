package dev.avishek.productservice.services;

import dev.avishek.productservice.dtos.GenricProductDto;
import dev.avishek.productservice.exceptions.NotFoundException;
import dev.avishek.productservice.thirdpartyclients.productservice.fakestore.FakeStoreProductDto;
import dev.avishek.productservice.thirdpartyclients.productservice.fakestore.FakeStoreProductServiceClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Primary
@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private FakeStoreProductServiceClient fakeStoreProductServiceClient;

    public FakeStoreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient) {
        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
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

    public GenricProductDto getProductById(Long id ) throws NotFoundException {
        System.out.println("FakeStoreProductService::getProductById");
        return convertFakeStoreProductDtoToGenricProductDto(fakeStoreProductServiceClient.getProductById(id));
    }

    public GenricProductDto addProduct(GenricProductDto product){
        System.out.println("FakeStoreProductService::addProduct");
        return convertFakeStoreProductDtoToGenricProductDto(fakeStoreProductServiceClient.addProduct(product));
    }

    public List<GenricProductDto> getAllProducts(){
        System.out.println("FakeStoreProductService::getAllProducts");
        List<FakeStoreProductDto> fakeStoreProductDtos = fakeStoreProductServiceClient.getAllProducts();
        List<GenricProductDto> genricProductDtos = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
            genricProductDtos.add(convertFakeStoreProductDtoToGenricProductDto((fakeStoreProductDto)));
        }
        return genricProductDtos;
    }

    public GenricProductDto deleteProductById(Long id){
        System.out.println("FakeStoreProductService::deleteProductById");
        return convertFakeStoreProductDtoToGenricProductDto(fakeStoreProductServiceClient.deleteProductById(id));
    }

    public GenricProductDto updateProduct(Long id, GenricProductDto product){
        System.out.println("FakeStoreProductService::updateProduct");
        return convertFakeStoreProductDtoToGenricProductDto(fakeStoreProductServiceClient.updateProduct(id, product));
    }
}
