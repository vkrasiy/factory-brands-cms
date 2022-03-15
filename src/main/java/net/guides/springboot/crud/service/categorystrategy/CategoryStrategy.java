package net.guides.springboot.crud.service.categorystrategy;

import com.fasterxml.jackson.databind.JsonNode;
import net.guides.springboot.crud.model.Brand;
import net.guides.springboot.crud.service.DataStrategy;

public interface CategoryStrategy {
    JsonNode getCategories(Brand brand);
    DataStrategy getBrandStrategy();
}
