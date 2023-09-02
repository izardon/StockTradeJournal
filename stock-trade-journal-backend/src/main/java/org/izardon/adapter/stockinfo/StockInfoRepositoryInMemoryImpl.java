package org.izardon.adapter.stockinfo;

import org.izardon.entity.model.stockinfo.StockInfo;
import org.izardon.usecase.stockinfo.StockInfoRepository;

import java.util.ArrayList;
import java.util.List;

public class StockInfoRepositoryInMemoryImpl implements StockInfoRepository {

    private List<StockInfo> stockInfos;

    public StockInfoRepositoryInMemoryImpl() {
        stockInfos = new ArrayList<>();
    }

    @Override
    public void save(StockInfo stockInfo) {
        if (!stockInfos.contains(stockInfo)) {
            stockInfos.add(stockInfo);
        }
    }

    @Override
    public List<StockInfo> findAll() {
        return stockInfos;
    }
}
