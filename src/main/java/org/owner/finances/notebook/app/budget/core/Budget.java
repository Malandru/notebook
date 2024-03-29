package org.owner.finances.notebook.app.budget.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.owner.finances.notebook.app.user.core.User;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity(name = "budgets")
public class Budget
{
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id_budget")
    private UUID budgetID;

    @Column(name = "budget_name", nullable = false)
    private String budgetName;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @Column(name = "start_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    @Temporal(TemporalType.DATE)
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

    @JsonIgnore
    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
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
}
