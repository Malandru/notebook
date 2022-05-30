package org.owner.notebook.app.budget.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.owner.notebook.app.movement.core.Transaction;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity(name = "budget_items")
public class BudgetItem extends Transaction
{
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id_item")
    private UUID itemID;

    @ManyToOne
    @JoinColumn(name = "id_budget", nullable = false)
    private Budget budget;

    @Column(name = "month_day", nullable = false)
    private int monthDay;

    @Column(name = "year_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date yearDate;

    public UUID getItemID()
    {
        return itemID;
    }

    public void setItemID(UUID itemID)
    {
        this.itemID = itemID;
    }

    @JsonIgnore
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
