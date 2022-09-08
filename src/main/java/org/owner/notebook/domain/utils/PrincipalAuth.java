package org.owner.notebook.domain.utils;

import org.owner.notebook.app.user.core.User;
import org.springframework.security.core.Authentication;

public class PrincipalAuth
{
    public static User getPrincipal(Authentication authentication)
    {
        if (authentication != null)
            return (User) authentication.getPrincipal();
        return null;
    }
}
