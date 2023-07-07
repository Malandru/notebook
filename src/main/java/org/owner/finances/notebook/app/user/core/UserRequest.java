package org.owner.finances.notebook.app.user.core;

import org.owner.finances.notebook.domain.request.types.CreateRequest;
import org.owner.finances.notebook.domain.request.types.DeleteRequest;
import org.owner.finances.notebook.domain.request.types.DetailsRequest;
import org.owner.finances.notebook.domain.request.types.UpdateRequest;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class UserRequest
{
    @NotNull(groups = {UpdateRequest.class, DeleteRequest.class, DetailsRequest.class})
    private UUID userID;

    @NotEmpty(groups = {CreateRequest.class})
    private String username;

    @NotEmpty(groups = {CreateRequest.class})
    private String firstName;

    @NotEmpty(groups = {CreateRequest.class})
    private String lastName;

    @NotEmpty(groups = {CreateRequest.class})
    private String alias;

    @NotEmpty(groups = {CreateRequest.class})
    private String password;

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

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getAlias()
    {
        return alias;
    }

    public void setAlias(String alias)
    {
        this.alias = alias;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
