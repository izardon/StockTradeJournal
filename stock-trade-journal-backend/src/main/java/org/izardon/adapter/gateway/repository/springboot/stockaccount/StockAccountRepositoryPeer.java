package org.izardon.adapter.gateway.repository.springboot.stockaccount;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockAccountRepositoryPeer extends CrudRepository<StockAccountData, String> {
}
