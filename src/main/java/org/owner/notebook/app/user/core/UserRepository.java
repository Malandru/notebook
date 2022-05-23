package org.owner.notebook.app.user.core;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>
{
    User findByUserID(UUID userID);
    User findByUsername(String username);
}
