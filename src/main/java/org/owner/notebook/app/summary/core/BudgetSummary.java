package org.owner.notebook.app.summary.core;

import org.owner.notebook.app.budget.core.Budget;
import org.owner.notebook.app.budget.core.BudgetItem;
import org.owner.notebook.app.movement.core.Totals;

import java.util.Date;
import java.util.List;

public class BudgetSummary
{
    private String budgetName;
    private Date startDate;
    private Date endDate;

    private List<BudgetItem> monthlyItems;
    private List<BudgetItem> extraordinaryItems;

    private Totals totals;

    public BudgetSummary(Budget budget)
    {
        this.budgetName = budget.getBudgetName();
        this.startDate = budget.getStartDate();
        this.endDate = budget.getEndDate();
        this.totals = new Totals();
    }

    public void calculateTotals()
    {
       this.totals.calculateTotalsFromZero(monthlyItems);
       this.totals.calculateTotals(extraordinaryItems);
    }

    public String getBudgetName()
    {
        return budgetName;
    }

    public void setBudgetName(String budgetName)
    {
        this.budgetName = budgetName;
    }

    public Date getStartDate()
    {
        return startDate;
    }

    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }

    public Date getEndDate()
    {
        return endDate;
    }

    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }

    public List<BudgetItem> getMonthlyItems()
    {
        return monthlyItems;
    }

    public void setMonthlyItems(List<BudgetItem> monthlyItems)
    {
        this.monthlyItems = monthlyItems;
    }

    public List<BudgetItem> getExtraordinaryItems()
    {
        return extraordinaryItems;
    }

    public void setExtraordinaryItems(List<BudgetItem> extraordinaryItems)
    {
        this.extraordinaryItems = extraordinaryItems;
    }

    public Totals getTotals()
    {
        return totals;
    }

    public void setTotals(Totals totals)
    {
        this.totals = totals;
    }
}
