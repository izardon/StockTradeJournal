package org.izardon.application.springboot.web.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "org.izardon.adapter.gateway.repository",
        entityManagerFactoryRef = "stockTradeJournalEntityManagerFactory",
        transactionManagerRef= "stockTradeJournalTransactionManager"
)
public class StockTradeJournalDataSourceConfiguration {
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.stock-trade-journal")
    public DataSourceProperties stockTradeJournalDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.stock-trade-journal.configuration")
    public DataSource stockTradeJournalDataSource() {
        return stockTradeJournalDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }

    @Bean(name = "stockTradeJournalEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean stockTradeJournalEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(stockTradeJournalDataSource())
                .packages("org.izardon.adapter.gateway.repository")
                .build();
    }

    @Bean
    public PlatformTransactionManager stockTradeJournalTransactionManager(
            final @Qualifier("stockTradeJournalEntityManagerFactory") LocalContainerEntityManagerFactoryBean stockTradeJournalEntityManagerFactory) {
        return new JpaTransactionManager(stockTradeJournalEntityManagerFactory.getObject());
    }
}
