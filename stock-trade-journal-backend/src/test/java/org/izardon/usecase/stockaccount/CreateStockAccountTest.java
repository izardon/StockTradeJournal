package org.izardon.usecase.stockaccount;

import org.izardon.adapter.stockaccount.StockAccountRepositoryInMemoryImpl;
import org.izardon.usecase.JpaApplicationTest;
import org.izardon.usecase.stockaccount.create.CreateStockAccountInput;
import org.izardon.usecase.stockaccount.create.CreateStockAccountOutput;
import org.izardon.usecase.stockaccount.create.CreateStockAccountUseCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(classes= JpaApplicationTest.class)
@Rollback(false)
public class CreateStockAccountTest {
    @Test
    public void create_stock_account_should_succeed() throws Exception {
        // Arrange
        StockAccountRepository stockAccountRepository = new StockAccountRepositoryInMemoryImpl();
        CreateStockAccountUseCase createStockAccountUseCase = new CreateStockAccountUseCase(stockAccountRepository);
        CreateStockAccountInput input = new CreateStockAccountInput();
        CreateStockAccountOutput output = new CreateStockAccountOutput();
        input.setName("firstStockAccount");

        // Act
        createStockAccountUseCase.execute(input, output);

        // Assert
        Assert.assertEquals("firstStockAccount", output.getName());
    }

}
