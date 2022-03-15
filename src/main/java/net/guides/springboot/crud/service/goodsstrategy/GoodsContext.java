package net.guides.springboot.crud.service.goodsstrategy;

import com.fasterxml.jackson.databind.JsonNode;
import net.guides.springboot.crud.exception.ResourceNotFoundException;
import net.guides.springboot.crud.model.Brand;
import net.guides.springboot.crud.service.DataStrategy;
import net.guides.springboot.crud.service.brandcommands.CommandExecutor;
import net.guides.springboot.crud.service.categorystrategy.CategoryStrategy;
import net.guides.springboot.crud.service.categorystrategy.responses.Category;
import net.guides.springboot.crud.service.goodsstrategy.model.GoodsResponse;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GoodsContext {
    private final Map<DataStrategy, GoodStrategy> categoryStrategies = new HashMap<>();
    private final CommandExecutor commandExecutor;

    public GoodsContext(CommandExecutor commandExecutor, List<GoodStrategy> strategies) {
        this.commandExecutor = commandExecutor;
        strategies.forEach(strategy -> categoryStrategies.put(strategy.getGoodsStrategy(), strategy));
    }

    public GoodsResponse resolveAllGoods(Brand brand) throws ResourceNotFoundException {
        GoodStrategy goodStrategy;
        if (brand.getIsApi()) {
            goodStrategy = categoryStrategies.get(DataStrategy.API);
        } else {
            goodStrategy = categoryStrategies.get(DataStrategy.SCRAPPING);
        }

        JsonNode goods = goodStrategy.getGoods(brand);
        return commandExecutor.handleGoods(brand.getName(), goods);
    }

}

