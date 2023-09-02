package org.izardon.usecase.stockaccount;


import org.izardon.entity.model.stockaccount.StockAccount;

import java.util.List;
import java.util.Optional;

public interface StockAccountRepository {
    void save(StockAccount stockAccount);

    List<StockAccount> findAll();
}
