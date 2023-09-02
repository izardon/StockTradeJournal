package org.izardon.adapter.gateway.repository.springboot.stockinfo;

import org.apache.commons.lang3.tuple.ImmutablePair;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class StockInfoDataKey implements Serializable {

    @Column(name = "stock_account_id")
    String stockAccountId;

    @Column(name = "stock_number")
    String stockNumber;

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof  StockInfoDataKey)) {
            return false;
        }
        StockInfoDataKey key = (StockInfoDataKey)obj;
        return stockAccountId.equals(key.stockAccountId) && stockNumber.equals(key.stockNumber);
    }

    @Override
    public int hashCode() {
        return new ImmutablePair<String, String>(stockAccountId, stockNumber).hashCode();
    }

    public StockInfoDataKey() {

    }

    public StockInfoDataKey(String stockAccountId, String stockNumber) {
        this.stockAccountId = stockAccountId;
        this.stockNumber = stockNumber;
    }

    public String getStockAccountId() {
        return stockAccountId;
    }

    public String getStockNumber() {
        return stockNumber;
    }
}
