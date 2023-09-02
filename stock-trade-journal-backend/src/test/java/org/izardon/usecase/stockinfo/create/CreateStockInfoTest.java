package org.izardon.usecase.stockinfo.create;

import org.izardon.adapter.stockinfo.StockInfoRepositoryInMemoryImpl;
import org.izardon.usecase.JpaApplicationTest;
import org.izardon.usecase.stockinfo.StockInfoRepository;
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
public class CreateStockInfoTest {
    @Test
    public void create_stock_info_should_succeed() throws Exception {
        // Arrange
        StockInfoRepository stockAccountRepository = new StockInfoRepositoryInMemoryImpl();
        CreateStockInfoUseCase createStockInfoUseCase = new CreateStockInfoUseCase(stockAccountRepository);
        CreateStockInfoInput input = new CreateStockInfoInput();
        CreateStockInfoOutput output = new CreateStockInfoOutput();
        input.setStockAccountId("firstAccount");
        input.setStockNumber("2330");
        input.setStockName("firstStockInfo");

        // Act
        createStockInfoUseCase.execute(input, output);

        // Assert
        Assert.assertEquals("2330", output.getStockNumber());
        Assert.assertEquals("firstStockInfo", output.getStockName());
    }

}
