package org.owner.finances.notebook.app.summary;

import org.owner.finances.notebook.app.budget.BudgetService;
import org.owner.finances.notebook.app.budget.core.Budget;
import org.owner.finances.notebook.app.budget.core.BudgetItemRepository;
import org.owner.finances.notebook.app.budget.core.BudgetRepository;
import org.owner.finances.notebook.app.budget.web.BudgetRequest;
import org.owner.finances.notebook.app.summary.core.BudgetSummary;
import org.owner.finances.notebook.app.summary.core.UserSummary;
import org.owner.finances.notebook.app.user.UserService;
import org.owner.finances.notebook.app.user.core.User;
import org.owner.finances.notebook.app.user.core.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SummaryService
{
    @Autowired
    private BudgetRepository budgetRepository;

    @Autowired
    private BudgetItemRepository budgetItemRepository;

    @Autowired
    private BudgetService budgetService;

    @Autowired
    private UserService userService;

    private BudgetSummary getBudgetSummary(Budget budget)
    {
        BudgetSummary budgetSummary = new BudgetSummary(budget);
        budgetSummary.setExtraordinaryItems(budgetItemRepository.findByBudgetAndYearDateNotNull(budget));
        budgetSummary.setMonthlyItems(budgetItemRepository.findByBudgetAndMonthDayNotNull(budget));
        budgetSummary.calculateTotals();
        return budgetSummary;
    }

    public BudgetSummary getBudgetSummary(BudgetRequest budgetRequest)
    {
        Budget budget = budgetService.findBudgetOrThrowError(budgetRequest.getBudgetID());
        return getBudgetSummary(budget);
    }

    public UserSummary getUserSummary(UserRequest userRequest)
    {
        Date currentDate = new Date();
        User user = userService.findUserOrThrowError(userRequest.getUserID());
        Budget currentBudget = budgetRepository.findByStartDateLessThanEqualAndEndDateGreaterThanEqual(currentDate, currentDate);

        UserSummary userSummary = new UserSummary();
        userSummary.setBudgets(budgetRepository.findByUser(user));

        if (currentBudget == null)
            return userSummary;

        userSummary.setCurrentBudgetID(currentBudget.getBudgetID());
        userSummary.setBudgetSummary(getBudgetSummary(currentBudget));
        return userSummary;
    }
}
