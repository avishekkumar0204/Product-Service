package dev.avishek.productservice.services;

import dev.avishek.productservice.exceptions.NotFoundException;
import dev.avishek.productservice.models.Category;

public interface CategoryService {
    Category getCategory(String uuid) throws NotFoundException;
}
