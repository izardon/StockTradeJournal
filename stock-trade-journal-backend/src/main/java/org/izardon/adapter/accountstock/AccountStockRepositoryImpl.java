package org.izardon.adapter.accountstock;


import org.izardon.adapter.gateway.repository.springboot.accountstock.AccountStockData;
import org.izardon.adapter.gateway.repository.springboot.accountstock.AccountStockDataMapper;
import org.izardon.adapter.gateway.repository.springboot.accountstock.AccountStockRepositoryPeer;
import org.izardon.entity.model.accountstock.AccountStock;
import org.izardon.usecase.accountstock.AccountStockRepository;

import java.util.List;

public class AccountStockRepositoryImpl implements AccountStockRepository {
    private final AccountStockRepositoryPeer accountStockRepositoryPeer;

    public AccountStockRepositoryImpl(AccountStockRepositoryPeer accountStockRepositoryPeer) {
        this.accountStockRepositoryPeer = accountStockRepositoryPeer;
    }

    @Override
    public void save(AccountStock accountStock) {
        AccountStockData accountStockData = AccountStockDataMapper.domainToData(accountStock);
        accountStockRepositoryPeer.save(accountStockData);
    }

    public List<AccountStock> findAll() {
        List<AccountStockData> accountStockDataList = (List<AccountStockData>) accountStockRepositoryPeer.findAll();
        return AccountStockDataMapper.dataToDomain(accountStockDataList);
    }
}
