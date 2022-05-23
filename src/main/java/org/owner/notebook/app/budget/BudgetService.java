package org.owner.notebook.app.budget;

import org.owner.notebook.app.budget.core.Budget;
import org.owner.notebook.app.budget.core.BudgetRepository;
import org.owner.notebook.app.budget.core.BudgetRequest;
import org.owner.notebook.app.user.UserService;
import org.owner.notebook.app.user.core.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BudgetService
{
    @Autowired
    private BudgetRepository budgetRepository;
    @Autowired
    private UserService userService;

    public Budget findBudgetOrThrowError(UUID budgetID)
    {
        Budget budget = budgetRepository.findByBudgetID(budgetID);
        if (budget == null)
            throw new BudgetNotFoundException(budgetID);
        return budget;
    }

    public Budget createBudget(BudgetRequest budgetRequest)
    {
        User user = userService.findUserOrThrowError(budgetRequest.getUserID());

        Budget budget = new Budget();
        budget.setBudgetName(budgetRequest.getBudgetName());
        budget.setStartDate(budgetRequest.getStartDate());
        budget.setEndDate((budgetRequest.getEndDate()));
        budget.setUser(user);

        return budgetRepository.save(budget);
    }
}
