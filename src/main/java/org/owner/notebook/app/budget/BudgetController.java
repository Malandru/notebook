package org.owner.notebook.app.budget;

import org.owner.notebook.app.budget.core.Budget;
import org.owner.notebook.app.budget.core.BudgetRequest;
import org.owner.notebook.domain.request.types.CreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BudgetController
{
    @Autowired
    private BudgetService budgetService;

    @PostMapping("/budgets/create")
    public ResponseEntity<Budget> createBudget(@Validated({CreateRequest.class}) @RequestBody BudgetRequest budgetRequest)
    {
        return ResponseEntity.ok(budgetService.createBudget(budgetRequest));
    }
}
