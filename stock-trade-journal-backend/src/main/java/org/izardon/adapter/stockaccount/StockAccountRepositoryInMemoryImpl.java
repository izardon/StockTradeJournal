package org.izardon.adapter.stockaccount;

import org.izardon.entity.model.stockaccount.StockAccount;
import org.izardon.usecase.stockaccount.StockAccountRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StockAccountRepositoryInMemoryImpl implements StockAccountRepository {

    private List<StockAccount> stockAccounts;

    public StockAccountRepositoryInMemoryImpl() {
        stockAccounts = new ArrayList<>();
    }

    @Override
    public void save(StockAccount stockAccount) {
        if (!stockAccounts.contains(stockAccount)) {
            stockAccounts.add(stockAccount);
        }
    }

    @Override
    public List<StockAccount> findAll() {
        return stockAccounts;
    }
}
