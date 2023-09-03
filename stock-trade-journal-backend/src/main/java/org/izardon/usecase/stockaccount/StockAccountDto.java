package org.izardon.usecase.stockaccount;

public class StockAccountDto {
    private String id;
    private String name;

    public StockAccountDto(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
