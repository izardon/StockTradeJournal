package org.izardon.entity.model.stockinfo;

import org.izardon.model.AggregateRoot;
import org.izardon.model.Entity;

public class StockInfo extends Entity<String> {
    private final String stockAccountId;
    private final String stockNumber;
    private final String stockName;

    public StockInfo(String stockAccountId, String stockNumber, String stockName) {
        super(stockAccountId);
        this.stockAccountId = stockAccountId;
        this.stockNumber = stockNumber;
        this.stockName = stockName;
    }

    public String getStockAccountId() {
        return stockAccountId;
    }

    public String getStockNumber() {
        return stockNumber;
    }

    public String getStockName() {
        return stockName;
    }
}
