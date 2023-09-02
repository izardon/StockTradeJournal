package org.izardon.usecase.stockinfo.query.getstockinfo;

import org.izardon.entity.model.stockinfo.StockInfo;

import java.util.List;

public class GetStockInfoListOutput {
    private List<StockInfo> stockInfoList;

    public List<StockInfo> getStockInfoList() {
        return stockInfoList;
    }

    public void setStockInfoList(List<StockInfo> stockInfoList) {
        this.stockInfoList = stockInfoList;
    }
}
