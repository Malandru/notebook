package org.owner.finances.notebook.core.account;

import org.owner.finances.notebook.core.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>
{
    List<Account> findByUser(User user);
}
