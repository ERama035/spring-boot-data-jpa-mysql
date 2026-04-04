package com.bezkoder.spring.datajpa.accounts;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonInclude
public class Account {

    private long id;

    private String accountName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

}
