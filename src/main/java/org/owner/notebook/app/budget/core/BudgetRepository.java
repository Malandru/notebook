package org.owner.notebook.app.budget.core;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, UUID>
{
    Budget findByBudgetID(UUID budgetID);
}
