package net.guides.springboot.crud.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.guides.springboot.crud.exception.ResourceNotFoundException;
import net.guides.springboot.crud.model.Brand;
import net.guides.springboot.crud.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandService {
    private final BrandRepository brandRepository;

    public Brand updateBrand(Brand brandDetails, Long brandId) throws ResourceNotFoundException {
        Brand brand = brandRepository.findById(brandId)
                .orElseThrow(() -> new ResourceNotFoundException("Brand not found for this id :: " + brandId));

        brand.setCategories(brandDetails.getCategories());
        return brandRepository.save(brand);
    }

    public Brand createBrand(Brand brand){
        return brandRepository.save(brand);
    }

    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    public void deleteBrand(Long id) {
        brandRepository.deleteById(id);
    }

    public Brand getBrandByName(String brandName)
            throws ResourceNotFoundException {
        return brandRepository.getBrandByName(brandName)
                .orElseThrow(() -> new ResourceNotFoundException("Brand not found for this name :: " + brandName));
    }

}
