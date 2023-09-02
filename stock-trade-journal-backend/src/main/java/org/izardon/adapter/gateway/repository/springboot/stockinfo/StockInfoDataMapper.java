package org.izardon.adapter.gateway.repository.springboot.stockinfo;


import org.izardon.entity.model.stockinfo.StockInfo;

import java.util.ArrayList;
import java.util.List;

public class StockInfoDataMapper {

    public static StockInfoData domainToData(StockInfo stockInfo) {
        return new StockInfoData( stockInfo.getId(), stockInfo.getStockNumber(), stockInfo.getStockName());
    }

    public static StockInfo dataToDomain(StockInfoData stockInfoData) {
        return new StockInfo(stockInfoData.getId().getStockAccountId(), stockInfoData.getId().getStockNumber(), stockInfoData.getStockName());
    }

    public static List<StockInfo> dataToDomain(List<StockInfoData> stockInfoDataList) {
        List<StockInfo> stockInfoList = new ArrayList<>();

        stockInfoDataList.forEach(stockInfoData -> stockInfoList.add(dataToDomain(stockInfoData)));

        return stockInfoList;
    }
}
