package org.owner.finances.notebook.app.budget.core;

import org.owner.finances.notebook.app.user.core.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, UUID>
{
    Budget findByBudgetID(UUID budgetID);
    List<Budget> findByUser(User user);

    Budget findByStartDateLessThanEqualAndEndDateGreaterThanEqual(Date date, Date sameDate);
}
