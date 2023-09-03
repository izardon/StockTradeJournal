package org.izardon.entity.model.accountstock;

import org.izardon.model.Entity;

public class AccountStock extends Entity<String> {
    private final String stockAccountId;
    private final String stockCode;
    private final String stockName;

    public AccountStock(String stockAccountId, String stockCode, String stockName) {
        super(stockAccountId);
        this.stockAccountId = stockAccountId;
        this.stockCode = stockCode;
        this.stockName = stockName;
    }

    public String getStockAccountId() {
        return stockAccountId;
    }

    public String getStockCode() {
        return stockCode;
    }

    public String getStockName() {
        return stockName;
    }
}
