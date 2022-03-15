package net.guides.springboot.crud.service.goodsstrategy.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Element{
    public ArrayList<Goods> commercialComponents;
}
