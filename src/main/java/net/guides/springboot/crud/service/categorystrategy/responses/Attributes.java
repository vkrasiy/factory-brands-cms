package net.guides.springboot.crud.service.categorystrategy.responses;

import lombok.Data;

@Data
public class Attributes{
    public boolean mustDisplayContent;
    public boolean displayUnfolded;
    public boolean showSubcategories;
    public boolean isDivider;
    public boolean isSustainabilityCat;
    public boolean secondaryRootCategory;
    public String gridForcedView;
    public String customLayout;
}
