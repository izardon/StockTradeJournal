package org.izardon.service;


import org.izardon.adapter.service.StockPriceApiService;
import org.izardon.adapter.util.UrlHandler;
import org.izardon.usecase.JpaApplicationTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

import java.io.ByteArrayInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@ContextConfiguration(classes= JpaApplicationTest.class)
@Rollback(false)
public class StockPriceApiServiceTest {

    @Test
    public void get_stock_price_should_succeed() throws Exception {
        // Arrange
        UrlHandler mockUrlHandler = mock(UrlHandler.class);
        HttpURLConnection mockConnection = mock(HttpURLConnection.class);

        when(mockUrlHandler.openConnection(any(URL.class))).thenReturn(mockConnection);
        when(mockConnection.getInputStream()).thenReturn(new ByteArrayInputStream("{\"msgArray\": []}".getBytes()));
        when(mockConnection.getResponseCode()).thenReturn(HttpURLConnection.HTTP_OK);
        List<String> mockStockCodes = Arrays.asList("2330", "2317");

        StockPriceApiService stockPriceApiService = new StockPriceApiService(mockUrlHandler);

        // Act
        stockPriceApiService.getStockPrice(mockStockCodes);

        // Assert
        verify(mockUrlHandler, atLeastOnce()).openConnection(any(URL.class));
        verify(mockConnection, atLeastOnce()).getInputStream();
        verify(mockConnection, atLeastOnce()).getResponseCode();
    }
}
