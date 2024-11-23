package dev.avishek.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order extends BaseModel{
    @ManyToMany
    @JoinTable(
            name = "product_order_mapping",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")

    )
    private List<Product> products;

}
