package org.izardon.usecase.stockaccount;

public class StockAccountDto {
    private String stockAccountId;
    private String name;

    public StockAccountDto(String stockAccountId, String name) {
        this.stockAccountId = stockAccountId;
        this.name = name;
    }

    public String getStockAccountId() {
        return stockAccountId;
    }

    public String getName() {
        return name;
    }
}
