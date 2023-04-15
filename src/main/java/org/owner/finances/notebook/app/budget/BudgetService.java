package org.owner.finances.notebook.app.budget;

import org.owner.finances.notebook.app.budget.core.Budget;
import org.owner.finances.notebook.app.budget.core.BudgetItem;
import org.owner.finances.notebook.app.budget.core.BudgetItemRepository;
import org.owner.finances.notebook.app.budget.core.BudgetRepository;
import org.owner.finances.notebook.app.budget.web.BudgetItemRequest;
import org.owner.finances.notebook.app.budget.web.BudgetRequest;
import org.owner.finances.notebook.app.user.UserService;
import org.owner.finances.notebook.app.user.core.User;
import org.owner.finances.notebook.domain.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BudgetService
{
    @Autowired
    private BudgetRepository budgetRepository;

    @Autowired
    private BudgetItemRepository budgetItemRepository;

    @Autowired
    private UserService userService;

    public Budget findBudgetOrThrowError(UUID budgetID)
    {
        Budget budget = budgetRepository.findByBudgetID(budgetID);
        if (budget == null)
            throw new NotFoundException(Budget.class, budgetID);
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

    public BudgetItem createBudgetItem(BudgetItemRequest budgetItemRequest)
    {
        Budget budget = findBudgetOrThrowError(budgetItemRequest.getBudgetID());

        BudgetItem budgetItem = new BudgetItem();
        budgetItem.setBudget(budget);
        budgetItem.setPeriodType(budgetItemRequest.getPeriodType());
        budgetItem.setMonthDay(budgetItemRequest.getMonthDay());
        budgetItem.setYearDate(budgetItemRequest.getYearDate());

        budgetItem.setConcept(budgetItemRequest.getConcept());
        budgetItem.setAmount(budgetItemRequest.getAmount());
        budgetItem.setCategory(budgetItemRequest.getCategory());

        return budgetItemRepository.save(budgetItem);
    }

    public List<BudgetItem> findBudgetItems(BudgetItemRequest budgetItemRequest)
    {
        return budgetItemRepository.findByBudgetBudgetID(budgetItemRequest.getBudgetID());
    }
}
