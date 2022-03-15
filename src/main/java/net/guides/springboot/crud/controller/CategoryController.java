package net.guides.springboot.crud.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.guides.springboot.crud.exception.ResourceNotFoundException;
import net.guides.springboot.crud.model.Brand;
import net.guides.springboot.crud.model.CategoryEntity;
import net.guides.springboot.crud.service.CategoryService;
import net.guides.springboot.crud.service.categorystrategy.responses.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@RestController()
@RequestMapping(value = "/api/v1/categories")
@Slf4j
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/{brand}")
    public List<Category> getAllCategoriesByBrand(@PathVariable(value = "brand")
                                                              String brand) throws ResourceNotFoundException {
        return categoryService.findAllCategoriesByBrandName(brand);
    }

    @PostMapping("/{brandName}")
    public List<CategoryEntity> createBrand(@PathVariable(value = "brandName")
                                         String brandName, @Valid @RequestBody List<CategoryEntity> categories) throws ResourceNotFoundException {
        System.out.println(brandName);
        return categoryService.saveCategories(brandName, categories);
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<CategoryEntity> updateBrand(@PathVariable(value = "id") Long brandId,
                                             @Valid @RequestBody CategoryEntity categoryEntity) throws ResourceNotFoundException {
        return ResponseEntity.ok(categoryService.updateCategory(categoryEntity));
    }
}
