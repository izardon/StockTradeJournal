package org.izardon.usecase.accountstock.create;

import org.izardon.entity.model.accountstock.AccountStock;
import org.izardon.usecase.accountstock.AccountStockRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateAccountStockUseCase {
    private AccountStockRepository accountStockRepository;

    @Autowired
    public CreateAccountStockUseCase(AccountStockRepository accountStockRepository) {
        this.accountStockRepository = accountStockRepository;
    }

    public void execute(CreateAccountStockInput input, CreateAccountStockOutput output) {
        AccountStock accountStock = new AccountStock(input.getStockAccountId(), input.getStockCode(), input.getStockName());

        accountStockRepository.save(accountStock);

        output.setStockId(accountStock.getId());
        output.setStockCode(accountStock.getStockCode());
        output.setStockName(accountStock.getStockName());
    }
}
