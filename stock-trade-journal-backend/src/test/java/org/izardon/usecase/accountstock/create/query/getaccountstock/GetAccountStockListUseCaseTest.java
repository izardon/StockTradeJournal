package org.izardon.usecase.accountstock.create.query.getaccountstock;

import org.izardon.adapter.presenter.accountstock.getcontent.AccountStockListViewModel;
import org.izardon.adapter.accountstock.AccountStockRepositoryInMemoryImpl;
import org.izardon.entity.model.accountstock.AccountStock;
import org.izardon.usecase.JpaApplicationTest;
import org.izardon.usecase.accountstock.AccountStockDto;
import org.izardon.usecase.accountstock.AccountStockDtoMapper;
import org.izardon.usecase.accountstock.AccountStockRepository;
import org.izardon.usecase.accountstock.query.getaccountstock.GetAccountStockListOutput;
import org.izardon.usecase.accountstock.query.getaccountstock.GetAccountStockListUseCase;
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
public class GetAccountStockListUseCaseTest {

    @Test
    public void get_single_stock_info_should_succeed() {
        // Arrange
        AccountStockRepository accountStockRepository = new AccountStockRepositoryInMemoryImpl();
        GetAccountStockListUseCase getAccountStockListUseCase = new GetAccountStockListUseCase(accountStockRepository);
        GetAccountStockListOutput output = new GetAccountStockListOutput();
        AccountStockDtoMapper stockAccountDtoMapper = new AccountStockDtoMapper();
        create_single_stock_info(accountStockRepository);
        List<AccountStockDto> accountStockDtos;

        // Act
        getAccountStockListUseCase.execute(output);

        accountStockDtos = stockAccountDtoMapper.domainToDto(output.getAccountStockList());
        AccountStockListViewModel accountStockListViewModel = new AccountStockListViewModel(accountStockDtos);
        // Assert
        Assert.assertEquals("台積電", accountStockListViewModel.getAccountStockDtos().get(0).getName());
        Assert.assertEquals("2330", accountStockListViewModel.getAccountStockDtos().get(0).getNumber());
    }

    private void create_single_stock_info(AccountStockRepository accountStockRepository) {
        String stockAccountId1 = "accountId";
        String stockCode = "2330";
        String stockName = "台積電";
        AccountStock accountStock = new AccountStock(stockAccountId1, stockCode, stockName);
        accountStockRepository.save(accountStock);
    }
}
