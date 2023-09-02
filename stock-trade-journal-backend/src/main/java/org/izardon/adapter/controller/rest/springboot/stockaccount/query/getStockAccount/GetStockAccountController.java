package org.izardon.adapter.controller.rest.springboot.stockaccount.query.getStockAccount;

import org.izardon.adapter.presenter.board.getcontent.StockAccountListViewModel;
import org.izardon.usecase.stockaccount.StockAccountDto;
import org.izardon.usecase.stockaccount.StockAccountDtoMapper;
import org.izardon.usecase.stockaccount.query.getstockaccount.GetStockAccountListOutput;
import org.izardon.usecase.stockaccount.query.getstockaccount.GetStockAccountListUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "${CORS_URLS}")
public class GetStockAccountController {

    private GetStockAccountListUseCase getStockAccountListUseCase;

    @Autowired
    public GetStockAccountController(GetStockAccountListUseCase getStockAccountListUseCase) {
        this.getStockAccountListUseCase = getStockAccountListUseCase;
    }

    @GetMapping(path = "/${STOCK_TRADE_JOURNAL_PREFIX}/stock-account-list", produces = "application/json")
    public StockAccountListViewModel getStockAccountList() {
        GetStockAccountListOutput output = new GetStockAccountListOutput();
        List<StockAccountDto> stockAccountDtos;
        StockAccountDtoMapper stockAccountDtoMapper = new StockAccountDtoMapper();

        getStockAccountListUseCase.execute(output);
        stockAccountDtos = stockAccountDtoMapper.domainToDto(output.getStockAccounts());

        return new StockAccountListViewModel(stockAccountDtos);
    }
}
