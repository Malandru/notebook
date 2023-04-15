package org.owner.finances.notebook.app.user.core;

public enum Role
{
    ROLE_USER,
    ROLE_ADMIN;

    public String getRoleName()
    {
        return this.name();
    }
}
