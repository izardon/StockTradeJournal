package org.izardon.usecase.stockaccount;


import org.izardon.entity.model.stockaccount.StockAccount;

import java.util.List;

public interface StockAccountRepository {
    void save(StockAccount stockAccount);

    List<StockAccount> findAll();
}
