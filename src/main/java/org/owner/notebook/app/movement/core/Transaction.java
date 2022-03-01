package org.owner.notebook.app.movement.core;

import javax.persistence.*;

@MappedSuperclass
public abstract class Transaction
{
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    protected Category category;

    @Column(nullable = false)
    protected String concept;

    @Column(nullable = false)
    protected Double amount;

    @ManyToOne
    @JoinColumn(name = "tag_id")
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
