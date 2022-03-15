package net.guides.springboot.crud.service.brandcommands;

import com.fasterxml.jackson.databind.JsonNode;
import net.guides.springboot.crud.service.categorystrategy.responses.Category;
import net.guides.springboot.crud.service.goodsstrategy.model.GoodsResponse;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CommandExecutor {
    private final Map<BrandName, BrandCommand> brandsCommandMap = new HashMap<>();
    
    public CommandExecutor(List<BrandCommand> brandsCommands) {
        brandsCommands.forEach( command -> brandsCommandMap.put(command.getBrandName(), command));
    }

    public List<Category> handleCategories(String brandName, JsonNode jsonNode){
        BrandCommand command = brandsCommandMap.get(BrandName.valueOf(brandName.toUpperCase()));
        return command.handleCategories(jsonNode);
    }

    public GoodsResponse handleGoods(String brandName, JsonNode jsonNode){
        BrandCommand command = brandsCommandMap.get(BrandName.valueOf(brandName.toUpperCase()));
        return command.handleGoods(jsonNode);
    }
}
