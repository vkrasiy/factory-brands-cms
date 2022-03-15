package net.guides.springboot.crud.service;

import lombok.AllArgsConstructor;
import net.guides.springboot.crud.exception.ResourceNotFoundException;
import net.guides.springboot.crud.model.Brand;
import net.guides.springboot.crud.model.CategoryEntity;
import net.guides.springboot.crud.repository.BrandRepository;
import net.guides.springboot.crud.repository.CategoryRepository;
import net.guides.springboot.crud.service.categorystrategy.CategoryContext;
import net.guides.springboot.crud.service.categorystrategy.responses.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoryService {
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;
    private final CategoryContext context;

    public List<Category> findAllCategoriesByBrandName(String brandName) throws ResourceNotFoundException {
        System.err.println(brandName);
        Brand brand = brandRepository.getBrandByName(brandName)
                .orElseThrow(() -> new ResourceNotFoundException("Brand not found for this name :: " + brandName));
        return context.resolveAllCategories(brand);
    }

    public List<CategoryEntity> saveCategories(String brandName, List<CategoryEntity> categories) throws ResourceNotFoundException {
        Brand brand = brandRepository.getBrandByName(brandName)
                .orElseThrow(() -> new ResourceNotFoundException("Brand not found for this name :: " + brandName));
        brand.getCategories().addAll(categories);
        return brandRepository.save(brand).getCategories();
    }

    public CategoryEntity updateCategory(CategoryEntity category) throws ResourceNotFoundException {
        return categoryRepository.saveAndFlush(category);
    }
}
