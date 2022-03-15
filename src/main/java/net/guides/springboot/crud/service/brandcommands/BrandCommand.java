package net.guides.springboot.crud.service.brandcommands;

import com.fasterxml.jackson.databind.JsonNode;
import net.guides.springboot.crud.service.categorystrategy.responses.Category;
import net.guides.springboot.crud.service.goodsstrategy.model.GoodsResponse;

import java.util.List;

public interface BrandCommand {
    List<Category> handleCategories(JsonNode jsonCategories);
    GoodsResponse handleGoods(JsonNode jsonCategories);
    BrandName getBrandName();

}
