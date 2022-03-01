package org.owner.notebook.app.movement.core;

import org.owner.notebook.app.account.core.Account;
import org.owner.notebook.app.sheet.core.Sheet;

import javax.persistence.*;

@Entity(name = "movements")
public class Movement extends Transaction
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movement")
    private Long movementID;

    @ManyToOne
    private Sheet sheet;

    @ManyToOne
    private Account account;

    @Column(nullable = false)
    private Boolean realized;
    private String comment;

    public Long getMovementID()
    {
        return movementID;
    }

    public void setMovementID(Long movementID)
    {
        this.movementID = movementID;
    }

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
