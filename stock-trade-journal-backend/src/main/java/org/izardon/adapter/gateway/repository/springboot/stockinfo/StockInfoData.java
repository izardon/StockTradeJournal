package org.izardon.adapter.gateway.repository.springboot.stockinfo;

import org.izardon.adapter.gateway.repository.springboot.stockaccount.StockAccountData;

import javax.persistence.*;

@Entity
@Table(name="stock_info")
public class StockInfoData {

    @EmbeddedId
    StockInfoDataKey id;

    @Column(name = "stock_name")
    private String stockName;

    public StockInfoData() {

    }
    public StockInfoData(String stockAccountId, String stockNumber, String stockName) {
        this.id = new StockInfoDataKey(stockAccountId, stockNumber);
        this.stockName = stockName;
    }

    public StockInfoDataKey getId() {
        return id;
    }

    public String getStockName() {
        return stockName;
    }
}
