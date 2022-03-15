package net.guides.springboot.crud.service.categorystrategy;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import net.guides.springboot.crud.model.Brand;
import net.guides.springboot.crud.model.Link;
import net.guides.springboot.crud.service.DataStrategy;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class CategoryAPIStrategy implements CategoryStrategy {
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public JsonNode getCategories(Brand brand) {
        Link categoryLink = brand.getBaseCategoryLink();
        log.info("get categories of brand " + brand);
        return findCategoriesByApi(categoryLink.getUrl());
    }

    @Override
    public DataStrategy getBrandStrategy() {
        return DataStrategy.API;
    }

    private JsonNode findCategoriesByApi(String url) {
        log.info("get categories " + url);
        return restTemplate.getForEntity(url, JsonNode.class).getBody();
    }


}
