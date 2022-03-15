package net.guides.springboot.crud.service.categorystrategy.responses;

import lombok.Data;

import java.util.List;

@Data
public class Category{
    public int id;
    public String name;
    public String sectionName;
    public List<Subcategory> subcategories;
    public String layout;
    public String contentType;
    public Seo seo;
    public Attributes attributes;
    public String key;
    public boolean isRedirected;
    public boolean isCurrent;
    public boolean isSelected;
    public boolean hasSubcategories;
    public boolean irrelevant;
    public ViewOptions viewOptions;
    public int menuLevel;
    public boolean moreInfoAdded;
}
