package org.izardon.usecase.stockinfo.create.query.getstockinfo;

import org.izardon.adapter.presenter.stockaccount.getcontent.StockAccountListViewModel;
import org.izardon.adapter.presenter.stockinfo.getcontent.StockInfoListViewModel;
import org.izardon.adapter.stockaccount.StockAccountRepositoryInMemoryImpl;
import org.izardon.adapter.stockinfo.StockInfoRepositoryInMemoryImpl;
import org.izardon.entity.model.stockaccount.StockAccount;
import org.izardon.entity.model.stockinfo.StockInfo;
import org.izardon.usecase.JpaApplicationTest;
import org.izardon.usecase.stockaccount.StockAccountDto;
import org.izardon.usecase.stockaccount.StockAccountDtoMapper;
import org.izardon.usecase.stockaccount.StockAccountRepository;
import org.izardon.usecase.stockaccount.query.getstockaccount.GetStockAccountListOutput;
import org.izardon.usecase.stockaccount.query.getstockaccount.GetStockAccountListUseCase;
import org.izardon.usecase.stockinfo.StockInfoDto;
import org.izardon.usecase.stockinfo.StockInfoDtoMapper;
import org.izardon.usecase.stockinfo.StockInfoRepository;
import org.izardon.usecase.stockinfo.query.getstockinfo.GetStockInfoListOutput;
import org.izardon.usecase.stockinfo.query.getstockinfo.GetStockInfoListUseCase;
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
public class GetStockInfoListUseCaseTest {

    @Test
    public void get_single_stock_info_should_succeed() {
        // Arrange
        StockInfoRepository stockInfoRepository = new StockInfoRepositoryInMemoryImpl();
        GetStockInfoListUseCase getStockInfoListUseCase = new GetStockInfoListUseCase(stockInfoRepository);
        GetStockInfoListOutput output = new GetStockInfoListOutput();
        StockInfoDtoMapper stockAccountDtoMapper = new StockInfoDtoMapper();
        create_single_stock_info(stockInfoRepository);
        List<StockInfoDto> stockInfoDtos;

        // Act
        getStockInfoListUseCase.execute(output);

        stockInfoDtos = stockAccountDtoMapper.domainToDto(output.getStockInfoList());
        StockInfoListViewModel stockInfoListViewModel = new StockInfoListViewModel(stockInfoDtos);
        // Assert
        Assert.assertEquals("台積電", stockInfoListViewModel.getStockInfoDtos().get(0).getName());
        Assert.assertEquals("2330", stockInfoListViewModel.getStockInfoDtos().get(0).getNumber());
    }

    private void create_single_stock_info(StockInfoRepository stockInfoRepository) {

        String stockAccountId1 = "accountId";
        String stockNumber = "2330";
        String stockName = "台積電";
        StockInfo stockInfo = new StockInfo(stockAccountId1, stockNumber, stockName);
        stockInfoRepository.save(stockInfo);
    }
}
