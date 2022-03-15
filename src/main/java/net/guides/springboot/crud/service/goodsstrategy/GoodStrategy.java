package net.guides.springboot.crud.service.goodsstrategy;

import com.fasterxml.jackson.databind.JsonNode;
import net.guides.springboot.crud.exception.ResourceNotFoundException;
import net.guides.springboot.crud.model.Brand;
import net.guides.springboot.crud.service.DataStrategy;

public interface GoodStrategy {
    JsonNode getGoods(Brand brand) throws ResourceNotFoundException;
    DataStrategy getGoodsStrategy();
}
