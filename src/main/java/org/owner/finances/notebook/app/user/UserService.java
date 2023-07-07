package org.owner.finances.notebook.app.user;

import org.owner.finances.notebook.app.user.core.Role;
import org.owner.finances.notebook.app.user.core.User;
import org.owner.finances.notebook.app.user.core.UserRepository;
import org.owner.finances.notebook.app.user.core.UserRequest;
import org.owner.finances.notebook.domain.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User findUserOrThrowError(String username)
    {
        User user = userRepository.findByUsername(username);
        if (user == null)
            throw new NotFoundException(User.class, username);
        return user;
    }

    public User findUserOrThrowError(UUID userID)
    {
        User user = userRepository.findByUserID(userID);
        if (user == null)
            throw new NotFoundException(User.class, userID);
        return user;
    }

    public User consultUser(UserRequest userRequest)
    {
        return findUserOrThrowError(userRequest.getUsername());
    }

    // User CRUD Methods

    public User createUser(UserRequest userRequest)
    {
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setAlias(userRequest.getAlias());
        user.setLastSessionDate(new Date());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.addRole(Role.ROLE_USER);
        return userRepository.save(user);
    }

    public User updateUser(UserRequest userRequest)
    {
        User user = findUserOrThrowError(userRequest.getUsername());
        if (isUpdated(user.getFirstName(), userRequest.getFirstName()))
            user.setFirstName(userRequest.getFirstName());
        if (isUpdated(user.getLastName(), userRequest.getLastName()))
            user.setLastName(userRequest.getLastName());
        if (isUpdated(user.getAlias(), userRequest.getAlias()))
            user.setAlias(userRequest.getAlias());
        if (isUpdated(user.getUsername(), userRequest.getUsername()))
            user.setUsername(user.getUsername());
        return userRepository.save(user);
    }

    public User deleteUser(UserRequest userRequest)
    {
        User user = findUserOrThrowError(userRequest.getUsername());
        userRepository.delete(user);
        return new User();
    }

    private boolean isUpdated(String original, String incoming)
    {
        return !(incoming == null || incoming.isEmpty() || original.equals(incoming));
    }
}
