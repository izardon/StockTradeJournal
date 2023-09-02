package org.izardon.entity.model.stockaccount;

import org.izardon.model.AggregateRoot;

public class StockAccount extends AggregateRoot<String> {

    private String name;

    public StockAccount(String id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
