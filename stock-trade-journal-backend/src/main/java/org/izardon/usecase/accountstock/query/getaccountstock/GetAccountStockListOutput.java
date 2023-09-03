package org.izardon.usecase.accountstock.query.getaccountstock;

import org.izardon.entity.model.accountstock.AccountStock;

import java.util.List;

public class GetAccountStockListOutput {
    private List<AccountStock> accountStockList;

    public List<AccountStock> getAccountStockList() {
        return accountStockList;
    }

    public void setAccountStockList(List<AccountStock> accountStockList) {
        this.accountStockList = accountStockList;
    }
}
