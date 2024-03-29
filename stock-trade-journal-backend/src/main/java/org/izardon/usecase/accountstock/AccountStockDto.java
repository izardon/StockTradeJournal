package org.izardon.usecase.accountstock;

public class AccountStockDto {

    private String number;
    private String name;

    public AccountStockDto(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
