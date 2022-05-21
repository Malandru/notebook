package org.owner.notebook.app.budget.core;

import org.owner.notebook.app.user.core.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "budgets")
public class Budget
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_budget")
    private Long budgetID;

    @Column(name = "budget_name", nullable = false)
    private String budgetName;

    @OneToMany(mappedBy = "budget")
    private List<BudgetItem> budgetItems;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @Column(name = "start_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date endDate;

    public Long getBudgetID()
    {
        return budgetID;
    }

    public void setBudgetID(Long budgetID)
    {
        this.budgetID = budgetID;
    }

    public String getBudgetName()
    {
        return budgetName;
    }

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

    public List<BudgetItem> getBudgetItems()
    {
        return budgetItems;
    }

    public void setBudgetItems(List<BudgetItem> budgetItems)
    {
        this.budgetItems = budgetItems;
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
