package org.owner.notebook.app.user;

import org.owner.notebook.app.user.core.User;
import org.owner.notebook.app.user.core.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController
{
    @Autowired
    private UserService userService;

    @PostMapping("/user/details")
    public ResponseEntity<User> consultUserDetails(@RequestBody UserRequest userRequest)
    {
        return ResponseEntity.ok(userService.consultUser(userRequest));
    }

    @PostMapping("/user/signup")
    public ResponseEntity<User> createUser(@RequestBody UserRequest userRequest)
    {
        return ResponseEntity.ok(userService.createUser(userRequest));
    }

    @PutMapping("/user/edit")
    public ResponseEntity<User> updateUser(@RequestBody UserRequest userRequest)
    {
        return ResponseEntity.ok(userService.updateUser(userRequest));
    }

    @DeleteMapping("/user/delete")
    public ResponseEntity<User> deleteUser(@RequestBody UserRequest userRequest)
    {
        return ResponseEntity.ok(userService.deleteUser(userRequest));
    }
}
