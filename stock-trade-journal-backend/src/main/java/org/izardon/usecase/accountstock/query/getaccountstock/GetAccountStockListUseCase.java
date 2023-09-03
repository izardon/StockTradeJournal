package org.izardon.usecase.accountstock.query.getaccountstock;


import org.izardon.entity.model.accountstock.AccountStock;
import org.izardon.usecase.accountstock.AccountStockRepository;

import java.util.List;

public class GetAccountStockListUseCase {

    private AccountStockRepository accountStockRepository;

    public GetAccountStockListUseCase(AccountStockRepository accountStockRepository) {
        this.accountStockRepository = accountStockRepository;
    }

    public void execute(GetAccountStockListOutput output) {
        List<AccountStock> accountStockList = accountStockRepository.findAll();
        output.setAccountStockList(accountStockList);
    }
}
