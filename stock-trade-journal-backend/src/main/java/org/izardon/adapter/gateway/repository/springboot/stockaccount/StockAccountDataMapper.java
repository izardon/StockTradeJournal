package org.izardon.adapter.gateway.repository.springboot.stockaccount;

import org.izardon.entity.model.stockaccount.StockAccount;
import org.izardon.usecase.stockaccount.StockAccountDto;

import java.util.ArrayList;
import java.util.List;

public class StockAccountDataMapper {

    public static StockAccountData domainToData(StockAccount stockAccount) {
        return new StockAccountData(stockAccount.getId(), stockAccount.getName());
    }

    public static StockAccount dataToDomain(StockAccountData stockAccountData) {
        StockAccount stockAccount = new StockAccount(stockAccountData.getId(), stockAccountData.getName());
        return stockAccount;
    }

    public static List<StockAccount> dataToDomain(List<StockAccountData> stockAccountDataList) {
        List<StockAccount> stockAccounts = new ArrayList<>();

        stockAccountDataList.forEach(stockAccountData -> stockAccounts.add(dataToDomain(stockAccountData)));

        return stockAccounts;
    }
}
