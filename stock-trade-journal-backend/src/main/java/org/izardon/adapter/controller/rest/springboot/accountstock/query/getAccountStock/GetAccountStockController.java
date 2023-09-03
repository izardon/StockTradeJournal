package org.izardon.adapter.controller.rest.springboot.accountstock.query.getAccountStock;

import org.izardon.adapter.presenter.accountstock.getcontent.AccountStockListViewModel;
import org.izardon.usecase.accountstock.AccountStockDto;
import org.izardon.usecase.accountstock.AccountStockDtoMapper;
import org.izardon.usecase.accountstock.query.getaccountstock.GetAccountStockListOutput;
import org.izardon.usecase.accountstock.query.getaccountstock.GetAccountStockListUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "${CORS_URLS}")
public class GetAccountStockController {

    private GetAccountStockListUseCase getAccountStockListUseCase;

    @Autowired
    public GetAccountStockController(GetAccountStockListUseCase getAccountStockListUseCase) {
        this.getAccountStockListUseCase = getAccountStockListUseCase;
    }

    @GetMapping(path = "/${STOCK_TRADE_JOURNAL_PREFIX}/stock-account-list/{stockAccountId}/account-stock-list", produces = "application/json")
    public AccountStockListViewModel getAccountStockList() {
        GetAccountStockListOutput output = new GetAccountStockListOutput();
        List<AccountStockDto> accountStockDtos;
        AccountStockDtoMapper accountStockDtoMapper = new AccountStockDtoMapper();

        getAccountStockListUseCase.execute(output);
        accountStockDtos = accountStockDtoMapper.domainToDto(output.getAccountStockList());

        return new AccountStockListViewModel(accountStockDtos);
    }
}
