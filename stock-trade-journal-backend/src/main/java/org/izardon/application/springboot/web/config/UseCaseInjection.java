package org.izardon.application.springboot.web.config;

import org.izardon.model.DomainEventBus;
import org.izardon.usecase.stockaccount.StockAccountRepository;
import org.izardon.usecase.stockaccount.create.CreateStockAccountUseCase;
import org.izardon.usecase.stockaccount.query.getstockaccount.GetStockAccountListUseCase;
import org.izardon.usecase.stockinfo.StockInfoRepository;
import org.izardon.usecase.stockinfo.create.CreateStockInfoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("StockTradeJournalUseCaseInjection")
public class UseCaseInjection {
    private StockAccountRepository stockAccountRepository;
    private StockInfoRepository stockInfoRepository;

    private DomainEventBus eventBus;

    @Bean(name="GetStockAccountListUseCase")
    public GetStockAccountListUseCase getStockAccountListUseCase() {
        return new GetStockAccountListUseCase(stockAccountRepository);
    }

    @Bean(name="CreateStockAccountUseCase")
    public CreateStockAccountUseCase createStockAccountUseCase() {
        return new CreateStockAccountUseCase(stockAccountRepository);
    }

    @Bean(name="CreateStockInfoUseCase")
    public CreateStockInfoUseCase createStockInfoUseCase() {
        return new CreateStockInfoUseCase(stockInfoRepository);
    }

    @Autowired
    public void setStockAccountRepository(StockAccountRepository stockAccountRepository) {
        this.stockAccountRepository = stockAccountRepository;
    }

    @Autowired
    public void setStockInfoRepository(StockInfoRepository stockInfoRepository) {
        this.stockInfoRepository = stockInfoRepository;
    }
}
