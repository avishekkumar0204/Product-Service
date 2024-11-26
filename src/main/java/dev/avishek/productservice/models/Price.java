package dev.avishek.productservice.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Price extends BaseModel{
    private String currency;
    private double price;
}
