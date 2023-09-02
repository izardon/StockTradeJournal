package org.izardon.application.springboot.web.config;

import org.izardon.model.DomainEventBus;
import org.izardon.usecase.stockaccount.StockAccountRepository;
import org.izardon.usecase.stockaccount.query.getstockaccount.GetStockAccountListUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("StockTradeJournalUseCaseInjection")
public class UseCaseInjection {
    private StockAccountRepository stockAccountRepository;

    private DomainEventBus eventBus;

    @Bean(name="GetStockAccountListUseCase")
    public GetStockAccountListUseCase getStockAccountListUseCase() {
        return new GetStockAccountListUseCase(stockAccountRepository);
    }

    @Autowired
    public void setStockAccountRepository(StockAccountRepository stockAccountRepository) {
        this.stockAccountRepository = stockAccountRepository;
    }
}
