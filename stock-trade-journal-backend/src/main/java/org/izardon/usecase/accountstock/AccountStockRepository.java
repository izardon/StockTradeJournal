package org.izardon.usecase.accountstock;


import org.izardon.entity.model.accountstock.AccountStock;

import java.util.List;

public interface AccountStockRepository {
    void save(AccountStock accountStock);

    List<AccountStock> findAll();
}
