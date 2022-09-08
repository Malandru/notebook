package org.owner.notebook.app.account.core;

import org.owner.notebook.domain.request.types.CreateRequest;
import org.owner.notebook.domain.request.types.DeleteRequest;
import org.owner.notebook.domain.request.types.DetailsRequest;
import org.owner.notebook.domain.request.types.UpdateRequest;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AccountRequest
{
    @NotNull(groups = {UpdateRequest.class, DeleteRequest.class, DetailsRequest.class})
    private Integer accountID;

    @NotEmpty(groups = {CreateRequest.class, UpdateRequest.class, DetailsRequest.class})
    private String username;

    @NotEmpty(groups = {CreateRequest.class, UpdateRequest.class})
    private String accountAlias;

    @NotNull(groups = {CreateRequest.class, UpdateRequest.class})
    private double balance;

    public Integer getAccountID()
    {
        return accountID;
    }

    public void setAccountID(Integer accountID)
    {
        this.accountID = accountID;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getAccountAlias()
    {
        return accountAlias;
    }

    public void setAccountAlias(String accountAlias)
    {
        this.accountAlias = accountAlias;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }
}
