package net.guides.springboot.crud.service.categorystrategy.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Seo{
    public int seoCategoryId;
    public String keyword;
    public boolean irrelevant;
    public boolean isHiddenInMenu;
}
