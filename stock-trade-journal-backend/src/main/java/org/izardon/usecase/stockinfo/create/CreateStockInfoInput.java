package org.izardon.usecase.stockinfo.create;

public class CreateStockInfoInput {
    private String stockAccountId;
    private String stockNumber;
    private String stockName;

    public String getStockAccountId() {
        return stockAccountId;
    }

    public void setStockAccountId(String stockAccountId) {
        this.stockAccountId = stockAccountId;
    }

    public String getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(String stockNumber) {
        this.stockNumber = stockNumber;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }
}
