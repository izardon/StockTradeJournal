package org.izardon.adapter.controller.rest.springboot.stockinfo.query.getStockInfo;

import org.izardon.adapter.presenter.stockinfo.getcontent.StockInfoListViewModel;
import org.izardon.usecase.stockinfo.StockInfoDto;
import org.izardon.usecase.stockinfo.StockInfoDtoMapper;
import org.izardon.usecase.stockinfo.query.getstockinfo.GetStockInfoListOutput;
import org.izardon.usecase.stockinfo.query.getstockinfo.GetStockInfoListUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "${CORS_URLS}")
public class GetStockInfoController {

    private GetStockInfoListUseCase getStockInfoListUseCase;

    @Autowired
    public GetStockInfoController(GetStockInfoListUseCase getStockInfoListUseCase) {
        this.getStockInfoListUseCase = getStockInfoListUseCase;
    }

    @GetMapping(path = "/${STOCK_TRADE_JOURNAL_PREFIX}/stock-account-list/{stockAccountId}/stock-info-list", produces = "application/json")
    public StockInfoListViewModel getStockInfoList() {
        GetStockInfoListOutput output = new GetStockInfoListOutput();
        List<StockInfoDto> stockInfoDtos;
        StockInfoDtoMapper stockInfoDtoMapper = new StockInfoDtoMapper();

        getStockInfoListUseCase.execute(output);
        stockInfoDtos = stockInfoDtoMapper.domainToDto(output.getStockInfoList());

        return new StockInfoListViewModel(stockInfoDtos);
    }
}
