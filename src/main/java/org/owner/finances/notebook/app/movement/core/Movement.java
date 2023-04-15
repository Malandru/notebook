package org.owner.finances.notebook.app.movement.core;

import org.owner.finances.notebook.app.sheet.core.Sheet;
import org.owner.finances.notebook.app.account.core.Account;

import javax.persistence.*;

@Entity(name = "movements")
public class Movement extends Transaction
{
    @ManyToOne
    @JoinColumn(name = "sheet_id", nullable = false)
    private Sheet sheet;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Column(nullable = false)
    private Boolean realized;
    private String comment;

    public Sheet getSheet()
    {
        return sheet;
    }

    public void setSheet(Sheet sheet)
    {
        this.sheet = sheet;
    }

    public Account getAccount()
    {
        return account;
    }

    public void setAccount(Account account)
    {
        this.account = account;
    }

    public Boolean getRealized()
    {
        return realized;
    }

    public void setRealized(Boolean realized)
    {
        this.realized = realized;
    }

    public String getComment()
    {
        return comment;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }
}
