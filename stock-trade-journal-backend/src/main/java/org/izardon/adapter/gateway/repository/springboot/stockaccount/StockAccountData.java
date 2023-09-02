package org.izardon.adapter.gateway.repository.springboot.stockaccount;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stock_account")
public class StockAccountData {

    @Id
    @Column(name="stock_account_id")
    private String stockAccountId;

    @Column(name = "name")
    private String name;
}
