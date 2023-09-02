package org.izardon.usecase.stockinfo.query.getstockinfo;


import org.izardon.entity.model.stockinfo.StockInfo;
import org.izardon.usecase.stockinfo.StockInfoRepository;

import java.util.List;

public class GetStockInfoListUseCase {

    private StockInfoRepository stockInfoRepository;

    public GetStockInfoListUseCase(StockInfoRepository stockInfoRepository) {
        this.stockInfoRepository = stockInfoRepository;
    }

    public void execute(GetStockInfoListOutput output) {
        List<StockInfo> stockInfoList = stockInfoRepository.findAll();
        output.setStockInfoList(stockInfoList);
    }
}
