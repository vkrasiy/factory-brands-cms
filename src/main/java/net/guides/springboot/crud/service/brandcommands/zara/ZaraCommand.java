package net.guides.springboot.crud.service.brandcommands.zara;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import net.guides.springboot.crud.responses.ProductsResponse;
import net.guides.springboot.crud.service.brandcommands.BrandCommand;
import net.guides.springboot.crud.service.brandcommands.BrandName;
import net.guides.springboot.crud.service.categorystrategy.responses.Category;
import net.guides.springboot.crud.service.categorystrategy.responses.RootCategory;
import net.guides.springboot.crud.service.goodsstrategy.Goods;
import net.guides.springboot.crud.service.goodsstrategy.model.GoodsResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Slf4j
@Component
public class ZaraCommand implements BrandCommand {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<Category> handleCategories(JsonNode jsonCategories) {
        try {
            log.info(jsonCategories.toString());
            return objectMapper.readValue(String.valueOf(jsonCategories), new TypeReference<RootCategory>() {
            }).categories;
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return Collections.emptyList();
    }

    @Override
    public GoodsResponse handleGoods(JsonNode jsonGoods) {
        try {
            log.info(jsonGoods.toString());
            GoodsResponse response =  objectMapper.readValue(String.valueOf(jsonGoods), new TypeReference<GoodsResponse>() {
            });


        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return null;
    }

    @Override
    public BrandName getBrandName() {
        return BrandName.ZARA;
    }
}
