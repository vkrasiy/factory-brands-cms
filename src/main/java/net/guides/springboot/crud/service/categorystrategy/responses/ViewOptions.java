package net.guides.springboot.crud.service.categorystrategy.responses;

import lombok.Data;

@Data
public class ViewOptions{
    public String zoom;
    public boolean isDefault;
    public boolean isForced;
}
