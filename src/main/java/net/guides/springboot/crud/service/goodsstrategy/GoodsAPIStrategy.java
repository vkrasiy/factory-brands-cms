package net.guides.springboot.crud.service.goodsstrategy;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import net.guides.springboot.crud.exception.ResourceNotFoundException;
import net.guides.springboot.crud.model.Brand;
import net.guides.springboot.crud.model.CategoryEntity;
import net.guides.springboot.crud.model.Link;
import net.guides.springboot.crud.service.DataStrategy;
import net.guides.springboot.crud.service.categorystrategy.responses.Category;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class GoodsAPIStrategy implements GoodStrategy {
    private final String DEFAULT = "default";
    private final RestTemplate restTemplate = new RestTemplate();


    private JsonNode findCategoriesByApi(String url) {
        log.info("get categories " + url);
        return restTemplate.getForEntity(url, JsonNode.class).getBody();
    }


    @Override
    public JsonNode getGoods(Brand brand) throws ResourceNotFoundException {
        CategoryEntity category = brand.getCategories().stream()
                .filter(cat ->DEFAULT.equals(cat.getName()))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException(""));
        log.info("get goods of " + String.format(brand.getProductCategoryLink().getUrl(),
                category.getPath()));
        return findCategoriesByApi(String.format(brand.getProductCategoryLink().getUrl(),
                category.getPath()));
    }

    @Override
    public DataStrategy getGoodsStrategy() {
        return DataStrategy.API;
    }
}
