package org.owner.notebook.app.budget.core;

import org.owner.notebook.domain.request.types.CreateRequest;
import org.owner.notebook.domain.request.types.DeleteRequest;
import org.owner.notebook.domain.request.types.UpdateRequest;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

public class BudgetRequest
{
    @NotNull(groups = {UpdateRequest.class, DeleteRequest.class})
    private UUID budgetID;

    @NotEmpty(groups = {CreateRequest.class})
    private String budgetName;

    @NotNull(groups = {CreateRequest.class})
    private UUID userID;

    @NotNull(groups = {CreateRequest.class})
    private Date startDate;

    @NotNull(groups = {CreateRequest.class})
    private Date endDate;

    public UUID getBudgetID()
    {
        return budgetID;
    }

    public void setBudgetID(UUID budgetID)
    {
        this.budgetID = budgetID;
    }

    public String getBudgetName()
    {
        return budgetName;
    }

    public void setBudgetName(String budgetName)
    {
        this.budgetName = budgetName;
    }

    public UUID getUserID()
    {
        return userID;
    }

    public void setUserID(UUID userID)
    {
        this.userID = userID;
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
}
