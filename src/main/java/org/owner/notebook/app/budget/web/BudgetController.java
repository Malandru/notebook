package org.owner.notebook.app.budget.web;

import org.owner.notebook.app.budget.BudgetService;
import org.owner.notebook.app.budget.core.Budget;
import org.owner.notebook.app.budget.core.BudgetItem;
import org.owner.notebook.domain.request.types.CreateRequest;
import org.owner.notebook.domain.request.types.DetailsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BudgetController
{
    @Autowired
    private BudgetService budgetService;

    @PostMapping("/budget/create")
    public ResponseEntity<Budget> createBudget(@Validated({CreateRequest.class}) @RequestBody BudgetRequest budgetRequest)
    {
        return ResponseEntity.ok(budgetService.createBudget(budgetRequest));
    }

    @PostMapping("/budget/details")
    public ResponseEntity<Budget> budgetDetails(@Validated({DetailsRequest.class}) @RequestBody BudgetRequest budgetRequest)
    {
        return ResponseEntity.ok(budgetService.findBudgetOrThrowError(budgetRequest.getBudgetID()));
    }

    @PostMapping("/budget/item/create")
    public ResponseEntity<BudgetItem> createBudgetItem(@Validated({CreateRequest.class}) @RequestBody BudgetItemRequest budgetItemRequest)
    {
        return ResponseEntity.ok(budgetService.createBudgetItem(budgetItemRequest));
    }

    @PostMapping("/budget/items")
    public ResponseEntity<List<BudgetItem>> budgetItems(@Validated({DetailsRequest.class}) @RequestBody BudgetItemRequest budgetItemRequest)
    {
        return ResponseEntity.ok(budgetService.findBudgetItems(budgetItemRequest));
    }
}
