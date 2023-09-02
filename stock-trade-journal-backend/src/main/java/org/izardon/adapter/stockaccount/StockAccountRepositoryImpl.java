package org.izardon.adapter.stockaccount;

import org.izardon.adapter.gateway.repository.springboot.stockaccount.StockAccountData;
import org.izardon.adapter.gateway.repository.springboot.stockaccount.StockAccountDataMapper;
import org.izardon.adapter.gateway.repository.springboot.stockaccount.StockAccountRepositoryPeer;
import org.izardon.entity.model.stockaccount.StockAccount;
import org.izardon.usecase.stockaccount.StockAccountRepository;

import java.util.List;

public class StockAccountRepositoryImpl implements StockAccountRepository {
    private final StockAccountRepositoryPeer stockAccountRepositoryPeer;

    public StockAccountRepositoryImpl(StockAccountRepositoryPeer stockAccountRepositoryPeer) {
        this.stockAccountRepositoryPeer = stockAccountRepositoryPeer;
    }

    @Override
    public void save(StockAccount stockAccount) {
        StockAccountData stockAccountData = StockAccountDataMapper.domainToData(stockAccount);
        stockAccountRepositoryPeer.save(stockAccountData);
    }

    public List<StockAccount> findAll() {
        List<StockAccountData> stockAccountDataList = (List<StockAccountData>) stockAccountRepositoryPeer.findAll();
        return StockAccountDataMapper.dataToDomain(stockAccountDataList);
    }
}
