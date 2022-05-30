package org.owner.notebook.app.budget.core;

import org.owner.notebook.app.movement.core.TransactionRequest;
import org.owner.notebook.domain.request.types.CreateRequest;
import org.owner.notebook.domain.request.types.DeleteRequest;
import org.owner.notebook.domain.request.types.DetailsRequest;
import org.owner.notebook.domain.request.types.UpdateRequest;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

public class BudgetItemRequest extends TransactionRequest
{
    @NotNull(groups = {CreateRequest.class, UpdateRequest.class, DeleteRequest.class, DetailsRequest.class})
    private UUID budgetID;

    private int monthDay;
    @NotNull(groups = {CreateRequest.class})
    private Date yearDate;

    public UUID getBudgetID()
    {
        return budgetID;
    }

    public void setBudgetID(UUID budgetID)
    {
        this.budgetID = budgetID;
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
