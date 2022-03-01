package org.owner.notebook.app.budget.core;

import org.owner.notebook.app.movement.core.Transaction;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "budget_items")
public class BudgetItem extends Transaction
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private Long itemID;

    @ManyToOne
    private Budget budget;

    private int monthDay;

    @Column(name = "end_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date yearDate;

    public Long getItemID()
    {
        return itemID;
    }

    public void setItemID(Long itemID)
    {
        this.itemID = itemID;
    }

    public Budget getBudget()
    {
        return budget;
    }

    public void setBudget(Budget budget)
    {
        this.budget = budget;
    }

    public int getMonthDay()
    {
        return monthDay;
    }

    public void setMonthDay(int monthDay)
    {
        this.monthDay = monthDay;
    }

    public Date getYearDate()
    {
        return yearDate;
    }

    public void setYearDate(Date yearDate)
    {
        this.yearDate = yearDate;
    }
}
