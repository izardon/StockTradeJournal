package org.izardon.usecase.stockinfo;


import org.izardon.entity.model.stockinfo.StockInfo;

import java.util.ArrayList;
import java.util.List;

public class StockInfoDtoMapper {

    public StockInfoDto domainToDto(StockInfo stockInfo) {
        return new StockInfoDto(
                stockInfo.getStockNumber(),
                stockInfo.getStockName()
        );
    }

    public List<StockInfoDto> domainToDto(List<StockInfo> stockInfoList) {
        List<StockInfoDto> stockInfoDtos = new ArrayList<>();

        stockInfoList.forEach(stockInfo -> stockInfoDtos.add(domainToDto(stockInfo)));

        return stockInfoDtos;
    }
}
