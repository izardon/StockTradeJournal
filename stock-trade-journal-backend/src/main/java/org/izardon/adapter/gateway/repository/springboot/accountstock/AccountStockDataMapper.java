package org.izardon.adapter.gateway.repository.springboot.accountstock;


import org.izardon.entity.model.accountstock.AccountStock;

import java.util.ArrayList;
import java.util.List;

public class AccountStockDataMapper {

    public static AccountStockData domainToData(AccountStock accountStock) {
        return new AccountStockData( accountStock.getId(), accountStock.getStockCode(), accountStock.getStockName());
    }

    public static AccountStock dataToDomain(AccountStockData accountStockData) {
        return new AccountStock(accountStockData.getId().getStockAccountId(), accountStockData.getId().getStockCode(), accountStockData.getStockName());
    }

    public static List<AccountStock> dataToDomain(List<AccountStockData> accountStockDataList) {
        List<AccountStock> accountStockList = new ArrayList<>();

        accountStockDataList.forEach(accountStockData -> accountStockList.add(dataToDomain(accountStockData)));

        return accountStockList;
    }
}
