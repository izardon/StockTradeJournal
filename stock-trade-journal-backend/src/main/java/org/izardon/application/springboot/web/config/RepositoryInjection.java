package org.izardon.application.springboot.web.config;

import org.izardon.adapter.gateway.repository.springboot.stockaccount.StockAccountRepositoryPeer;
import org.izardon.adapter.stockaccount.StockAccountRepositoryImpl;
import org.izardon.model.DomainEventBus;
import org.izardon.usecase.stockaccount.StockAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = "classpath:/application.properties")
@Configuration("StockTradeJournalRepositoryInjection")
public class RepositoryInjection {
    private StockAccountRepositoryPeer stockAccountRepositoryPeer;

    @Autowired
    public void setStockAccountRepositoryPeer(StockAccountRepositoryPeer stockAccountRepositoryPeer) {
        this.stockAccountRepositoryPeer = stockAccountRepositoryPeer;
    }

    @Bean(name="stockAccountRepository")
    public StockAccountRepository stockAccountRepository() {
        return new StockAccountRepositoryImpl(stockAccountRepositoryPeer);
    }

    @Bean(name="stockTradeJournalEventBus")
    public DomainEventBus eventBus() {
        return new DomainEventBus();
    }
}
