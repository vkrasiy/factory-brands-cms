package net.guides.springboot.crud.service.goodsstrategy.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import net.guides.springboot.crud.service.categorystrategy.responses.Seo;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Goods {
    public int id;
    public String reference;
    public String type;
    public String kind;
    public BrandModel brand;
    public ArrayList<Xmedia> xmedia;
    public String name;
    public String description;
    public int price;
    public int oldPrice;
    public int displayDiscountPercentage;
    public int section;
    public String sectionName;
    public String familyName;
    public String subfamilyName;
    public Seo seo;
    public String availability;
    public ArrayList<Object> tagTypes;
    public ExtraInfo extraInfo;
    public Detail detail;
    public int gridPosition;
    public int zoomedGridPosition;
    public int athleticzPosition;
    public ArrayList<Object> productTag;
    public String colorList;
    public boolean isDivider;
    public boolean hasXmediaDouble;
    public ArrayList<SimpleXmedia> simpleXmedia;
    public boolean showAvailability;
    public boolean priceUnavailable;
    public boolean isOnSale;
    public ColorInfo colorInfo;
}
