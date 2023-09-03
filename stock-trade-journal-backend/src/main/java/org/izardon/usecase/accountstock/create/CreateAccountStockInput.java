package org.izardon.usecase.accountstock.create;

public class CreateAccountStockInput {
    private String stockAccountId;
    private String stockCode;
    private String stockName;

    public String getStockAccountId() {
        return stockAccountId;
    }

    public void setStockAccountId(String stockAccountId) {
        this.stockAccountId = stockAccountId;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }
}
