package org.izardon.usecase.accountstock;


import org.izardon.entity.model.accountstock.AccountStock;

import java.util.ArrayList;
import java.util.List;

public class AccountStockDtoMapper {

    public AccountStockDto domainToDto(AccountStock accountStock) {
        return new AccountStockDto(
                accountStock.getStockCode(),
                accountStock.getStockName()
        );
    }

    public List<AccountStockDto> domainToDto(List<AccountStock> accountStockList) {
        List<AccountStockDto> accountStockDtos = new ArrayList<>();

        accountStockList.forEach(accountStock -> accountStockDtos.add(domainToDto(accountStock)));

        return accountStockDtos;
    }
}
