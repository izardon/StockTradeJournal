package org.izardon.usecase;

import org.izardon.application.springboot.web.StockTradeJournalWebMain;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;


@ComponentScan(basePackages={"org.izardon"}, excludeFilters= {
        @ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE, value= StockTradeJournalWebMain.class)})
@EntityScan(basePackages={"org.izardon"})
@SpringBootApplication
public abstract class JpaApplicationTest {
}
