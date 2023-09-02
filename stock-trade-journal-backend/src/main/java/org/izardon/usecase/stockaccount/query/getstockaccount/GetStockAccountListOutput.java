package org.izardon.usecase.stockaccount.query.getstockaccount;

import org.izardon.entity.model.stockaccount.StockAccount;

import java.util.List;

public class GetStockAccountListOutput {
    private List<StockAccount> stockAccounts;

    public List<StockAccount> getStockAccounts() {
        return stockAccounts;
    }

    public void setStockAccounts(List<StockAccount> stockAccounts) {
        this.stockAccounts = stockAccounts;
    }
}
