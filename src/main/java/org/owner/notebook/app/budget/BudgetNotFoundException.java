package org.owner.notebook.app.budget;

import org.owner.notebook.domain.error.ServerError;
import org.springframework.http.HttpStatus;

import java.util.UUID;

public class BudgetNotFoundException extends ServerError
{
    private static final String details = "Budget [%s] does not exist";

    public BudgetNotFoundException(UUID budgetID)
    {
        super(
                "Budget NOT found",
                String.format(details, budgetID),
                HttpStatus.NOT_FOUND);
    }
}
