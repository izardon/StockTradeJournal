package org.izardon.usecase.stockaccount;

import org.izardon.entity.model.stockaccount.StockAccount;

import java.util.ArrayList;
import java.util.List;

public class StockAccountDtoMapper {

    public StockAccountDto domainToDto(StockAccount stockAccount) {
        return new StockAccountDto(
                stockAccount.getId(),
                stockAccount.getName()
        );
    }

    public List<StockAccountDto> domainToDto(List<StockAccount> stockAccounts) {
        List<StockAccountDto> stockAccountDtos = new ArrayList<>();

        stockAccounts.forEach(stockAccount -> stockAccountDtos.add(domainToDto(stockAccount)));

        return stockAccountDtos;
    }
}
