package org.owner.notebook.app.budget.web;

import org.owner.notebook.app.budget.core.PeriodType;
import org.owner.notebook.app.movement.core.TransactionRequest;
import org.owner.notebook.domain.request.types.CreateRequest;
import org.owner.notebook.domain.request.types.DeleteRequest;
import org.owner.notebook.domain.request.types.DetailsRequest;
import org.owner.notebook.domain.request.types.UpdateRequest;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.UUID;

public class BudgetItemRequest extends TransactionRequest
{
    @NotNull(groups = {CreateRequest.class, UpdateRequest.class, DeleteRequest.class, DetailsRequest.class})
    private UUID budgetID;

    @NotNull(groups = {CreateRequest.class})
    private PeriodType periodType;

    @Min(value = 1, groups = CreateRequest.class)
    @Max(value = 31, groups = CreateRequest.class)
    private Integer monthDay;
    private Date yearDate;

    public UUID getBudgetID()
    {
        return budgetID;
    }

    public void setBudgetID(UUID budgetID)
    {
        this.budgetID = budgetID;
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

    @AssertTrue(groups = {CreateRequest.class})
    public boolean isPeriodTypeCorrect()
    {
        return  (PeriodType.MONTHLY.equals(periodType) && monthDay != null && yearDate == null) ||
                (PeriodType.YEARLY.equals(periodType) && yearDate != null && monthDay == null);
    }
}
