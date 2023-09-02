package org.izardon.adapter.stockinfo;


import org.izardon.adapter.gateway.repository.springboot.stockinfo.StockInfoData;
import org.izardon.adapter.gateway.repository.springboot.stockinfo.StockInfoDataMapper;
import org.izardon.adapter.gateway.repository.springboot.stockinfo.StockInfoRepositoryPeer;
import org.izardon.entity.model.stockinfo.StockInfo;
import org.izardon.usecase.stockinfo.StockInfoRepository;

import java.util.List;

public class StockInfoRepositoryImpl implements StockInfoRepository {
    private final StockInfoRepositoryPeer stockInfoRepositoryPeer;

    public StockInfoRepositoryImpl(StockInfoRepositoryPeer stockInfoRepositoryPeer) {
        this.stockInfoRepositoryPeer = stockInfoRepositoryPeer;
    }

    @Override
    public void save(StockInfo stockInfo) {
        StockInfoData stockInfoData = StockInfoDataMapper.domainToData(stockInfo);
        stockInfoRepositoryPeer.save(stockInfoData);
    }

    public List<StockInfo> findAll() {
        List<StockInfoData> stockInfoDataList = (List<StockInfoData>) stockInfoRepositoryPeer.findAll();
        return StockInfoDataMapper.dataToDomain(stockInfoDataList);
    }
}
