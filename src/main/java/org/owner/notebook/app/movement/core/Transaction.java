package org.owner.notebook.app.movement.core;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Transaction
{
    @Enumerated(EnumType.STRING)
    protected Category category;
    protected String concept;
    protected Double amount;

    @ManyToOne
    protected Tag tag;

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

    public Tag getTag()
    {
        return tag;
    }

    public void setTag(Tag tag)
    {
        this.tag = tag;
    }
}
