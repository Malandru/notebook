package org.owner.finances.notebook.app.summary;

import org.owner.finances.notebook.app.budget.web.BudgetRequest;
import org.owner.finances.notebook.app.summary.core.BudgetSummary;
import org.owner.finances.notebook.app.summary.core.UserSummary;
import org.owner.finances.notebook.app.user.core.UserRequest;
import org.owner.finances.notebook.domain.request.types.DetailsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SummaryController
{
    @Autowired
    private SummaryService summaryService;

    @PostMapping("/summary/budget")
    public ResponseEntity<BudgetSummary> budgetSummary(@Validated({DetailsRequest.class}) @RequestBody BudgetRequest budgetRequest)
    {
        return ResponseEntity.ok(summaryService.getBudgetSummary(budgetRequest));
    }

    @PostMapping("/summary/user")
    public ResponseEntity<UserSummary> userSummary(@Validated({DetailsRequest.class}) @RequestBody UserRequest userRequest)
    {
        return ResponseEntity.ok(summaryService.getUserSummary(userRequest));
    }
}
