package org.izardon.adapter.gateway.repository.springboot.stockaccount;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stock_account")
public class StockAccountData {

    @Id
    @Column(name="id")
    private String id;

    @Column(name = "name")
    private String name;

    public StockAccountData() {
    }

    public StockAccountData(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
