package net.guides.springboot.crud.service;

import lombok.AllArgsConstructor;
import net.guides.springboot.crud.exception.ResourceNotFoundException;
import net.guides.springboot.crud.model.Brand;
import net.guides.springboot.crud.repository.BrandRepository;
import net.guides.springboot.crud.responses.ProductsResponse;
import net.guides.springboot.crud.service.goodsstrategy.GoodsContext;
import net.guides.springboot.crud.service.goodsstrategy.model.GoodsResponse;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GoodsService {
    private final BrandRepository brandRepository;
    private final GoodsContext context;

    public ProductsResponse findAllGoodsByDefaultCategory(String brandName) throws ResourceNotFoundException {
        System.err.println(brandName);
        Brand brand = brandRepository.getBrandByName(brandName)
                .orElseThrow(() -> new ResourceNotFoundException("Brand not found for this name :: " + brandName));
        GoodsResponse response = context.resolveAllGoods(brand);
    }
}
