package net.guides.springboot.crud.service.brandcommands;

public enum BrandName {
    ZARA("zara"),
    CALVIN_KLEIN("calvin klein");

    private final String name;

    BrandName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
