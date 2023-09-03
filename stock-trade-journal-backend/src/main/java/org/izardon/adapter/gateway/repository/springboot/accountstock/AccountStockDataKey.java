package org.izardon.adapter.gateway.repository.springboot.accountstock;

import org.apache.commons.lang3.tuple.ImmutablePair;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AccountStockDataKey implements Serializable {

    @Column(name = "stock_account_id")
    String stockAccountId;

    @Column(name = "stock_code")
    String stockCode;

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AccountStockDataKey)) {
            return false;
        }
        AccountStockDataKey key = (AccountStockDataKey)obj;
        return stockAccountId.equals(key.stockAccountId) && stockCode.equals(key.stockCode);
    }

    @Override
    public int hashCode() {
        return new ImmutablePair<String, String>(stockAccountId, stockCode).hashCode();
    }

    public AccountStockDataKey() {

    }

    public AccountStockDataKey(String stockAccountId, String stockCode) {
        this.stockAccountId = stockAccountId;
        this.stockCode = stockCode;
    }

    public String getStockAccountId() {
        return stockAccountId;
    }

    public String getStockCode() {
        return stockCode;
    }
}
