package net.guides.springboot.crud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.guides.springboot.crud.service.BrandService;
import net.guides.springboot.crud.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.guides.springboot.crud.exception.ResourceNotFoundException;
import net.guides.springboot.crud.model.Brand;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
@Slf4j
public class BrandController {
	private final BrandService brandService;
	private CategoryService categoryService;

	@GetMapping("/brands")
	public List<Brand> getAllBrands() throws ResourceNotFoundException {
		return brandService.getAllBrands();
	}

	@GetMapping("/brands/{name}")
	public ResponseEntity<Brand> getBrandByName(@PathVariable(value = "name") String name)
			throws ResourceNotFoundException {
		System.out.println("brand name " + name);
		Brand brand = brandService.getBrandByName(name);
		return ResponseEntity.ok().body(brand);
	}

	@PostMapping("/brands")
	public Brand createBrand(@Valid @RequestBody Brand brand) {
		System.out.println(brand);
		return brandService.createBrand(brand);
	}

	@PutMapping("/brands/{id}")
	public ResponseEntity<Brand> updateBrand(@PathVariable(value = "id") Long brandId,
												@Valid @RequestBody Brand brandDetails) throws ResourceNotFoundException {
		return ResponseEntity.ok(brandService.updateBrand(brandDetails, brandId));
	}

	@DeleteMapping("/brands/{id}")
	public Map<String, Boolean> deleteBrand(@PathVariable(value = "id") Long brandId)
			throws ResourceNotFoundException {
		brandService.deleteBrand(brandId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
