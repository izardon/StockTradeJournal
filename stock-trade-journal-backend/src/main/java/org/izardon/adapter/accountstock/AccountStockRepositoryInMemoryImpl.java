package org.izardon.adapter.accountstock;

import org.izardon.entity.model.accountstock.AccountStock;
import org.izardon.usecase.accountstock.AccountStockRepository;

import java.util.ArrayList;
import java.util.List;

public class AccountStockRepositoryInMemoryImpl implements AccountStockRepository {

    private List<AccountStock> accountStocks;

    public AccountStockRepositoryInMemoryImpl() {
        accountStocks = new ArrayList<>();
    }

    @Override
    public void save(AccountStock accountStock) {
        if (!accountStocks.contains(accountStock)) {
            accountStocks.add(accountStock);
        }
    }

    @Override
    public List<AccountStock> findAll() {
        return accountStocks;
    }
}
