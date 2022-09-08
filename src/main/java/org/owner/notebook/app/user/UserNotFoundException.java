package org.owner.notebook.app.user;

import org.owner.notebook.domain.error.ServerError;
import org.springframework.http.HttpStatus;

import java.util.UUID;

public class UserNotFoundException extends ServerError
{
    private final static String ID_DETAILS = "User with ID [%s] does not exist";
    private final static String USERNAME_DETAILS = "Username [%s] does not exist";

    public UserNotFoundException(UUID userID)
    {
        super(
                "User not found",
                String.format(ID_DETAILS, userID),
                HttpStatus.NOT_FOUND);
    }

    public UserNotFoundException(String username)
    {
        super(
                "User not found",
                String.format(USERNAME_DETAILS, username),
                HttpStatus.NOT_FOUND);
    }
}
