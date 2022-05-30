package org.owner.notebook.app.budget.core;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BudgetItemRepository extends JpaRepository<BudgetItem, UUID>
{
    List<BudgetItem> findByBudgetBudgetID(UUID budgetID);
}
