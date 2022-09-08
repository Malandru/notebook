package org.owner.notebook.app.user.core;

import org.owner.notebook.domain.request.types.CreateRequest;
import org.owner.notebook.domain.request.types.DeleteRequest;
import org.owner.notebook.domain.request.types.DetailsRequest;
import org.owner.notebook.domain.request.types.UpdateRequest;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class UserRequest
{
    @NotNull(groups = {UpdateRequest.class, DeleteRequest.class, DetailsRequest.class})
    private UUID userID;

    @NotEmpty(groups = {CreateRequest.class, UpdateRequest.class})
    private String username;

    @NotEmpty(groups = {CreateRequest.class, UpdateRequest.class})
    private String fullName;

    @NotEmpty(groups = {CreateRequest.class})
    private String password;

    @NotEmpty(groups = {CreateRequest.class, UpdateRequest.class, DeleteRequest.class})
    private String role;

    public UUID getUserID()
    {
        return userID;
    }

    public void setUserID(UUID userID)
    {
        this.userID = userID;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
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
