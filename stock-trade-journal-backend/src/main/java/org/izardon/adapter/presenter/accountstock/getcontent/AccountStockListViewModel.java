package org.izardon.adapter.presenter.accountstock.getcontent;

import org.izardon.usecase.accountstock.AccountStockDto;

import java.util.List;

public class AccountStockListViewModel {
    private final List<AccountStockDto> accountStockDtos;

    public AccountStockListViewModel(List<AccountStockDto> accountStockDtos) {
        this.accountStockDtos = accountStockDtos;
    }

    public List<AccountStockDto> getAccountStockDtos() {
        return accountStockDtos;
    }
}
