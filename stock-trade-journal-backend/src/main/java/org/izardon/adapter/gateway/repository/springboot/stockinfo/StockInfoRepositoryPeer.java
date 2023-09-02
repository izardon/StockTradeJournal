package org.izardon.adapter.gateway.repository.springboot.stockinfo;

import org.izardon.adapter.gateway.repository.springboot.stockaccount.StockAccountData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockInfoRepositoryPeer extends CrudRepository<StockInfoData, String> {
}
