package org.izardon.usecase.accountstock.create;

import org.izardon.adapter.accountstock.AccountStockRepositoryInMemoryImpl;
import org.izardon.usecase.JpaApplicationTest;
import org.izardon.usecase.accountstock.AccountStockRepository;
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
public class CreateAccountStockTest {
    @Test
    public void create_stock_info_should_succeed() throws Exception {
        // Arrange
        AccountStockRepository stockAccountRepository = new AccountStockRepositoryInMemoryImpl();
        CreateAccountStockUseCase createAccountStockUseCase = new CreateAccountStockUseCase(stockAccountRepository);
        CreateAccountStockInput input = new CreateAccountStockInput();
        CreateAccountStockOutput output = new CreateAccountStockOutput();
        input.setStockAccountId("firstAccount");
        input.setStockCode("2330");
        input.setStockName("台積電");

        // Act
        createAccountStockUseCase.execute(input, output);

        // Assert
        Assert.assertEquals("2330", output.getStockCode());
        Assert.assertEquals("台積電", output.getStockName());
    }

}
