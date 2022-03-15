package net.guides.springboot.crud.controller;

import lombok.AllArgsConstructor;
import net.guides.springboot.crud.exception.ResourceNotFoundException;
import net.guides.springboot.crud.model.Brand;
import net.guides.springboot.crud.service.GoodsService;
import net.guides.springboot.crud.service.goodsstrategy.model.GoodsResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@RestController
public class GoodsController {
    private final GoodsService goodsService;

//    @GetMapping("/goods")
//    public List<Brand> getAllGoods() throws ResourceNotFoundException {
//        return goo.getAllBrands();
//    }

    @GetMapping("/goods/{brandName}")
    public ResponseEntity<GoodsResponse> getBrandByName(@PathVariable(value = "brandName") String brandName)
            throws ResourceNotFoundException {
        System.out.println("brand name " + brandName);
        GoodsResponse goods = goodsService.findAllGoodsByDefaultCategory(brandName);
        return ResponseEntity.ok().body(goods);
    }

}
