package org.izardon.adapter.presenter.stockinfo.getcontent;

import org.izardon.usecase.stockinfo.StockInfoDto;

import java.util.List;

public class StockInfoListViewModel {
    private List<StockInfoDto> stockInfoDtos;

    public StockInfoListViewModel(List<StockInfoDto> stockInfoDtos) {
        this.stockInfoDtos = stockInfoDtos;
    }

    public List<StockInfoDto> getStockInfoDtos() {
        return stockInfoDtos;
    }
}
