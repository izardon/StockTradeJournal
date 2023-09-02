package org.izardon.usecase.stockaccount.query.getstockaccount;

import org.izardon.adapter.presenter.board.getcontent.StockAccountListViewModel;
import org.izardon.adapter.stockaccount.StockAccountRepositoryInMemoryImpl;
import org.izardon.entity.model.stockaccount.StockAccount;
import org.izardon.usecase.JpaApplicationTest;
import org.izardon.usecase.stockaccount.StockAccountDto;
import org.izardon.usecase.stockaccount.StockAccountDtoMapper;
import org.izardon.usecase.stockaccount.StockAccountRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(classes= JpaApplicationTest.class)
@Rollback(false)
public class GetStockAccountListUseCaseTest {

    @Test
    public void get_stock_account_list_should_succeed() {
        // Arrange
        StockAccountRepository stockAccountRepository = new StockAccountRepositoryInMemoryImpl();
        GetStockAccountListUseCase getStockAccountListUseCase = new GetStockAccountListUseCase(stockAccountRepository);
        GetStockAccountListOutput output = new GetStockAccountListOutput();
        StockAccountDtoMapper stockAccountDtoMapper = new StockAccountDtoMapper();
        create_single_stock_account(stockAccountRepository);
        List<StockAccountDto> stockAccountDtoList;

        // Act
        getStockAccountListUseCase.execute(output);

        stockAccountDtoList = stockAccountDtoMapper.domainToDto(output.getStockAccounts());
        StockAccountListViewModel stockAccountListViewModel = new StockAccountListViewModel(stockAccountDtoList);
        // Assert
        Assert.assertEquals("firstId", stockAccountListViewModel.getStockAccountDtos().get(0).getStockAccountId());
        Assert.assertEquals("secondId", stockAccountListViewModel.getStockAccountDtos().get(1).getStockAccountId());
    }

    private void create_single_stock_account(StockAccountRepository stockAccountRepository) {
        String stockAccountId1 = "firstId";
        StockAccount stockAccount1 = new StockAccount(stockAccountId1, "firstStockAccount");
        stockAccountRepository.save(stockAccount1);

        String stockAccountId2 = "secondId";
        StockAccount stockAccount2 = new StockAccount(stockAccountId2, "secondStockAccount");
        stockAccountRepository.save(stockAccount2);
    }
}
