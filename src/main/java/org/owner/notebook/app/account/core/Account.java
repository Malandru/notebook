package org.owner.notebook.app.account.core;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.owner.notebook.app.user.core.User;

import javax.persistence.*;

@Entity(name = "accounts")
public class Account
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_account")
    private Integer accountID;

    @ManyToOne
    @JoinColumn(name = "id_user")
    @JsonBackReference
    private User user;

    @Column(name = "alias", nullable = false)
    private String accountAlias;

    @Column(nullable = false)
    private double balance;

    public Integer getAccountID()
    {
        return accountID;
    }

    public void setAccountID(Integer accountID)
    {
        this.accountID = accountID;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
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
