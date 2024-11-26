package dev.avishek.productservice.services;

import dev.avishek.productservice.Utils.Utils;
import dev.avishek.productservice.exceptions.NotFoundException;
import dev.avishek.productservice.models.Category;
import dev.avishek.productservice.repositories.CategoryRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Primary
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public Category getCategory(String uuid) throws NotFoundException {
        UUID validUuid = Utils.validateUUID(uuid);
        Optional<Category> categoryOptional = categoryRepository.findById(validUuid);
        if(categoryOptional.isEmpty()) {
            throw new NotFoundException("Category not found");
        }
        return categoryOptional.get();

    }


}
