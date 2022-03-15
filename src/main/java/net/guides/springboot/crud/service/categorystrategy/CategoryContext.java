package net.guides.springboot.crud.service.categorystrategy;

import com.fasterxml.jackson.databind.JsonNode;
import net.guides.springboot.crud.model.Brand;
import net.guides.springboot.crud.service.DataStrategy;
import net.guides.springboot.crud.service.brandcommands.CommandExecutor;
import net.guides.springboot.crud.service.categorystrategy.responses.Category;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CategoryContext {
    private final Map<DataStrategy, CategoryStrategy> categoryStrategies = new HashMap<>();
    private final CommandExecutor commandExecutor;

    public CategoryContext(CommandExecutor commandExecutor, List<CategoryStrategy> strategies) {
        this.commandExecutor = commandExecutor;
        strategies.forEach(strategy -> categoryStrategies.put(strategy.getBrandStrategy(), strategy));
    }

    public List<Category> resolveAllCategories(Brand brand) {
        CategoryStrategy categoryStrategy;
        if (brand.getIsApi()) {
            categoryStrategy = categoryStrategies.get(DataStrategy.API);
        } else {
            categoryStrategy = categoryStrategies.get(DataStrategy.SCRAPPING);
        }

        JsonNode categories = categoryStrategy.getCategories(brand);
        return commandExecutor.handleCategories(brand.getName(), categories);
    }

}
