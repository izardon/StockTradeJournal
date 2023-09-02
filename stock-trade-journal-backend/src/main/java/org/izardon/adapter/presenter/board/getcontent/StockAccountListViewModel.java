package org.izardon.adapter.presenter.board.getcontent;

import org.izardon.usecase.stockaccount.StockAccountDto;

import java.util.List;

public class StockAccountListViewModel {
    private List<StockAccountDto> stockAccountDtos;

    public StockAccountListViewModel(List<StockAccountDto> stockAccountDtos) {
        this.stockAccountDtos = stockAccountDtos;
    }

    public List<StockAccountDto> getStickyNoteDtos() {
        return stockAccountDtos;
    }
}
