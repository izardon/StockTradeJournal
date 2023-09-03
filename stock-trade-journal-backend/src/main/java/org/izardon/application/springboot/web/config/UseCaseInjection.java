package org.izardon.application.springboot.web.config;

import org.izardon.model.DomainEventBus;
import org.izardon.usecase.stockaccount.StockAccountRepository;
import org.izardon.usecase.stockaccount.create.CreateStockAccountUseCase;
import org.izardon.usecase.stockaccount.query.getstockaccount.GetStockAccountListUseCase;
import org.izardon.usecase.accountstock.AccountStockRepository;
import org.izardon.usecase.accountstock.create.CreateAccountStockUseCase;
import org.izardon.usecase.accountstock.query.getaccountstock.GetAccountStockListUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("StockTradeJournalUseCaseInjection")
public class UseCaseInjection {
    private StockAccountRepository stockAccountRepository;
    private AccountStockRepository accountStockRepository;

    private DomainEventBus eventBus;

    @Bean(name="GetStockAccountListUseCase")
    public GetStockAccountListUseCase getStockAccountListUseCase() {
        return new GetStockAccountListUseCase(stockAccountRepository);
    }

    @Bean(name="GetAccountStockListUseCase")
    public GetAccountStockListUseCase getAccountStockListUseCase() {
        return new GetAccountStockListUseCase(accountStockRepository);
    }

    @Bean(name="CreateStockAccountUseCase")
    public CreateStockAccountUseCase createStockAccountUseCase() {
        return new CreateStockAccountUseCase(stockAccountRepository);
    }

    @Bean(name="CreateAccountStockUseCase")
    public CreateAccountStockUseCase createAccountStockUseCase() {
        return new CreateAccountStockUseCase(accountStockRepository);
    }

    @Autowired
    public void setStockAccountRepository(StockAccountRepository stockAccountRepository) {
        this.stockAccountRepository = stockAccountRepository;
    }

    @Autowired
    public void setAccountStockRepository(AccountStockRepository accountStockRepository) {
        this.accountStockRepository = accountStockRepository;
    }
}
