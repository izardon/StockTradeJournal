package org.izardon.adapter.gateway.repository.springboot.accountstock;

import javax.persistence.*;

@Entity
@Table(name="account_stock")
public class AccountStockData {

    @EmbeddedId
    AccountStockDataKey id;

    @Column(name = "stock_name")
    private String stockName;

    public AccountStockData() {

    }
    public AccountStockData(String stockAccountId, String stockCode, String stockName) {
        this.id = new AccountStockDataKey(stockAccountId, stockCode);
        this.stockName = stockName;
    }

    public AccountStockDataKey getId() {
        return id;
    }

    public String getStockName() {
        return stockName;
    }
}
