package org.izardon.usecase.stockaccount.create;

import org.izardon.entity.model.stockaccount.StockAccount;
import org.izardon.usecase.stockaccount.StockAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class CreateStockAccountUseCase {
    private StockAccountRepository stockAccountRepository;

    @Autowired
    public CreateStockAccountUseCase(StockAccountRepository stockAccountRepository) {
        this.stockAccountRepository = stockAccountRepository;
    }

    public void execute(CreateStockAccountInput input, CreateStockAccountOutput output) {
        String stockAccountId = UUID.randomUUID().toString();
        StockAccount stockAccount = new StockAccount(stockAccountId, input.getName());

        stockAccountRepository.save(stockAccount);

        output.setId(stockAccount.getId());
        output.setName(stockAccount.getName());
    }
}
