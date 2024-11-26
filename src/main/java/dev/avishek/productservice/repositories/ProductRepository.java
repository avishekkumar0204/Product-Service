package dev.avishek.productservice.repositories;

import dev.avishek.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    List<Product> findAllByTitleAndPrice_currency(String title, String currency);

    // Not suggested
    @Query(value = CustomQueries.FIND_ALL_BY_TITLE, nativeQuery = true)
    List<Product> findAllByTitle(String title);

//    @Query("select Product from Product where Product.price.price <= :price")
//    List<Product> findAllProductByPrice_priceLesserThan(double price);
}
