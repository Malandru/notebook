package org.owner.finances.notebook.app.movement.core;

import java.util.List;

public class Totals
{
    private double totalIncomes;
    private double totalExpenses;
    private double totalSavings;
    private double totalInvestments;

    public Totals()
    {
        initializeToZero();
    }

    private void initializeToZero()
    {
        this.totalIncomes = 0;
        this.totalExpenses = 0;
        this.totalSavings = 0;
        this.totalInvestments = 0;
    }

    public void calculateTotalsFromZero(List<? extends Transaction> transactions)
    {
        initializeToZero();
        calculateTotals(transactions);
    }

    public void calculateTotals(List<? extends Transaction> transactions)
    {
        for (Transaction transaction: transactions)
        {
            switch (transaction.getCategory()) {
                case INCOME:
                    totalIncomes += transaction.getAmount();
                    break;
                case EXPENSE:
                    totalExpenses += transaction.getAmount();
                    break;
                case SAVING:
                    totalSavings += transaction.getAmount();
                    break;
                case INVESTMENT:
                    totalInvestments += transaction.getAmount();
                    break;
            }
        }
    }

    public double getTotalIncomes()
    {
        return totalIncomes;
    }

    public void setTotalIncomes(double totalIncomes)
    {
        this.totalIncomes = totalIncomes;
    }

    public double getTotalExpenses()
    {
        return totalExpenses;
    }

    public void setTotalExpenses(double totalExpenses)
    {
        this.totalExpenses = totalExpenses;
    }

    public double getTotalSavings()
    {
        return totalSavings;
    }

    public void setTotalSavings(double totalSavings)
    {
        this.totalSavings = totalSavings;
    }

    public double getTotalInvestments()
    {
        return totalInvestments;
    }

    public void setTotalInvestments(double totalInvestments)
    {
        this.totalInvestments = totalInvestments;
    }
}
