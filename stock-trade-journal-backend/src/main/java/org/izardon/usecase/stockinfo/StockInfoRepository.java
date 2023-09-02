package org.izardon.usecase.stockinfo;


import org.izardon.entity.model.stockinfo.StockInfo;

import java.util.List;

public interface StockInfoRepository {
    void save(StockInfo stockInfo);

    List<StockInfo> findAll();
}
