package org.owner.finances.notebook.app.budget.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.owner.finances.notebook.app.movement.core.Transaction;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "budget_items")
public class BudgetItem extends Transaction
{
    @ManyToOne
    @JoinColumn(name = "id_budget", nullable = false)
    private Budget budget;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "period_type", nullable = false)
    private PeriodType periodType;

    @Column(name = "month_day", nullable = true)
    private Integer monthDay;

    @Column(name = "year_date", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date yearDate;

    @JsonIgnore
    public Budget getBudget()
    {
        return budget;
    }

    public void setBudget(Budget budget)
    {
        this.budget = budget;
    }

    public PeriodType getPeriodType()
    {
        return periodType;
    }

    public void setPeriodType(PeriodType periodType)
    {
        this.periodType = periodType;
    }

    public Integer getMonthDay()
    {
        return monthDay;
    }

    public void setMonthDay(Integer monthDay)
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
