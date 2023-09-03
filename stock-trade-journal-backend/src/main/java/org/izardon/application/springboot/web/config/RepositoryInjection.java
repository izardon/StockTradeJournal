package org.izardon.application.springboot.web.config;

import org.izardon.adapter.gateway.repository.springboot.stockaccount.StockAccountRepositoryPeer;
import org.izardon.adapter.gateway.repository.springboot.accountstock.AccountStockRepositoryPeer;
import org.izardon.adapter.stockaccount.StockAccountRepositoryImpl;
import org.izardon.adapter.accountstock.AccountStockRepositoryImpl;
import org.izardon.model.DomainEventBus;
import org.izardon.usecase.stockaccount.StockAccountRepository;
import org.izardon.usecase.accountstock.AccountStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = "classpath:/application.properties")
@Configuration("StockTradeJournalRepositoryInjection")
public class RepositoryInjection {
    private StockAccountRepositoryPeer stockAccountRepositoryPeer;
    private AccountStockRepositoryPeer accountStockRepositoryPeer;

    @Autowired
    public void setStockAccountRepositoryPeer(StockAccountRepositoryPeer stockAccountRepositoryPeer) {
        this.stockAccountRepositoryPeer = stockAccountRepositoryPeer;
    }

    @Autowired
    public void setAccountStockRepositoryPeer(AccountStockRepositoryPeer accountStockRepositoryPeer) {
        this.accountStockRepositoryPeer = accountStockRepositoryPeer;
    }

    @Bean(name="stockAccountRepository")
    public StockAccountRepository stockAccountRepository() {
        return new StockAccountRepositoryImpl(stockAccountRepositoryPeer);
    }

    @Bean(name="accountStockRepository")
    public AccountStockRepository accountStockRepository() {
        return new AccountStockRepositoryImpl(accountStockRepositoryPeer);
    }

    @Bean(name="stockTradeJournalEventBus")
    public DomainEventBus eventBus() {
        return new DomainEventBus();
    }
}
