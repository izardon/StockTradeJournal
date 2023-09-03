package org.izardon.adapter.gateway.repository.springboot.accountstock;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountStockRepositoryPeer extends CrudRepository<AccountStockData, String> {
}
