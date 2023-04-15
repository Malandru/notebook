package org.owner.finances.notebook.app.budget.core;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BudgetItemRepository extends JpaRepository<BudgetItem, UUID>
{
    List<BudgetItem> findByBudgetBudgetID(UUID budgetID);
    List<BudgetItem> findByBudgetAndYearDateNotNull(Budget budget);
    List<BudgetItem> findByBudgetAndMonthDayNotNull(Budget budget);
}
