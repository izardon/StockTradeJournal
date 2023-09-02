package org.izardon.application.springboot.web;

import org.izardon.model.DomainEventBus;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.izardon"} )
public class StockTradeJournalWebMain implements CommandLineRunner {

    private DomainEventBus domainEventBus;

    public void setDomainEventBus(DomainEventBus domainEventBus) {
        this.domainEventBus = domainEventBus;
    }

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(StockTradeJournalWebMain.class) ;
        ConfigurableApplicationContext configurableApplicationContext = springApplication.run(args);
    }

    @Override
    public void run(String... arg0) throws Exception {
        System.out.println("StockTradeJournalWebMain run");
    }
}
