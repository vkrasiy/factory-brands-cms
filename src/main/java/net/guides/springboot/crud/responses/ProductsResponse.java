package net.guides.springboot.crud.responses;

import lombok.Data;
import net.guides.springboot.crud.service.goodsstrategy.model.Goods;
import net.guides.springboot.crud.service.goodsstrategy.model.ProductGroup;

import java.util.List;

@Data
public class ProductsResponse {
    private List<Goods> products;
}
