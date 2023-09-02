package org.izardon.usecase.stockaccount.query.getStockAccount;

import org.izardon.entity.model.stockaccount.StockAccount;
import org.izardon.usecase.stockaccount.StockAccountRepository;

import java.util.List;
import java.util.Optional;

public class GetStockAccountListUseCase {
    private StockAccountRepository stockAccountRepository;

    public GetStockAccountListUseCase(StockAccountRepository stockAccountRepository) {
        this.stockAccountRepository = stockAccountRepository;
    }

    public void execute(GetStockAccountListOutput output) {
        List<StockAccount> stockAccounts = stockAccountRepository.findAll();
        output.setStockAccounts(stockAccounts);
    }
}
