package org.owner.finances.notebook.app.summary.core;

import org.owner.finances.notebook.app.budget.core.Budget;

import java.util.List;
import java.util.UUID;

public class UserSummary
{
    private List<Budget> budgets;
    private UUID currentBudgetID;
    private BudgetSummary budgetSummary;

    public List<Budget> getBudgets()
    {
        return budgets;
    }

    public void setBudgets(List<Budget> budgets)
    {
        this.budgets = budgets;
    }

    public UUID getCurrentBudgetID()
    {
        return currentBudgetID;
    }

    public void setCurrentBudgetID(UUID currentBudgetID)
    {
        this.currentBudgetID = currentBudgetID;
    }

    public BudgetSummary getBudgetSummary()
    {
        return budgetSummary;
    }

    public void setBudgetSummary(BudgetSummary budgetSummary)
    {
        this.budgetSummary = budgetSummary;
    }
}
