package org.owner.notebook.app.user.core;

import javax.persistence.*;

@Entity(name = "roles")
public class Role
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private Integer roleID;

    @Column(name = "role", nullable = false, unique = true)
    private String role;

    public Integer getRoleID()
    {
        return roleID;
    }

    public void setRoleID(Integer roleID)
    {
        this.roleID = roleID;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }
}
