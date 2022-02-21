package org.owner.notebook.app.account.core;

import org.owner.notebook.app.user.core.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>
{
    List<Account> findByUser(User user);
    Account findByAccountID(Integer accountID);
    Account findByAccountIDAndUserUsername(Integer accountID, String username);
}
