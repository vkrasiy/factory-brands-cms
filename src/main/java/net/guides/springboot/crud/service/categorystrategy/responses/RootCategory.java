package net.guides.springboot.crud.service.categorystrategy.responses;

import lombok.Data;

import java.util.List;

@Data
public class RootCategory {
    public List<Category> categories;
}
