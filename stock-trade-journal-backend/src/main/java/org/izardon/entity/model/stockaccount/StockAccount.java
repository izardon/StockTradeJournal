package org.izardon.entity.model.stockaccount;

import org.izardon.model.AggregateRoot;

public class StockAccount extends AggregateRoot<String> {
    private String stockAccountId;
    private String name;

    public StockAccount(String s, String stockAccountId, String name) {
        super(s);
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
