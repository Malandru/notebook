package org.owner.notebook.app.user;

import org.owner.notebook.app.user.core.Role;
import org.owner.notebook.app.user.core.User;
import org.owner.notebook.app.user.core.UserRepository;
import org.owner.notebook.app.user.core.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
            throw new UserNotFoundException(username);
        return user;
    }

    public User findUserOrThrowError(UUID userID)
    {
        User user = userRepository.findByUserID(userID);
        if (user == null)
            throw new UserNotFoundException(userID);
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
        user.setFullName(userRequest.getFullName());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.addRole(Role.valueOf(userRequest.getRole()));  // TODO: add role validation
        return userRepository.save(user);
    }

    public User updateUser(UserRequest userRequest)
    {
        User user = findUserOrThrowError(userRequest.getUsername());
        user.setFullName(userRequest.getFullName());
        return userRepository.save(user);
    }

    public User deleteUser(UserRequest userRequest)
    {
        User user = findUserOrThrowError(userRequest.getUsername());
        userRepository.delete(user);
        return new User();
    }
}
