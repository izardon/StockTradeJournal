package org.izardon.usecase.stockinfo.create;

import org.izardon.entity.model.stockinfo.StockInfo;
import org.izardon.usecase.stockinfo.StockInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class CreateStockInfoUseCase {
    private StockInfoRepository stockInfoRepository;

    @Autowired
    public CreateStockInfoUseCase(StockInfoRepository stockInfoRepository) {
        this.stockInfoRepository = stockInfoRepository;
    }

    public void execute(CreateStockInfoInput input, CreateStockInfoOutput output) {
        StockInfo stockInfo = new StockInfo(input.getStockAccountId(), input.getStockNumber(), input.getStockName());

        stockInfoRepository.save(stockInfo);

        output.setStockId(stockInfo.getId());
        output.setStockNumber(stockInfo.getStockNumber());
        output.setStockName(stockInfo.getStockName());
    }
}
