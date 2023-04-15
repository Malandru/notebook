package org.owner.finances.notebook.app.movement.core;

import org.owner.finances.notebook.domain.request.types.CreateRequest;

import javax.validation.constraints.NotNull;

public class TransactionRequest
{
    @NotNull(groups = {CreateRequest.class})
    protected Category category;

    @NotNull(groups = {CreateRequest.class})
    protected String concept;

    protected Double amount;

    public Category getCategory()
    {
        return category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }

    public String getConcept()
    {
        return concept;
    }

    public void setConcept(String concept)
    {
        this.concept = concept;
    }

    public Double getAmount()
    {
        return amount;
    }

    public void setAmount(Double amount)
    {
        this.amount = amount;
    }
}
