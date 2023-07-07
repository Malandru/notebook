package org.owner.finances.notebook.app.user;

import org.owner.finances.notebook.app.user.core.User;
import org.owner.finances.notebook.app.user.core.UserRequest;
import org.owner.finances.notebook.domain.request.types.CreateRequest;
import org.owner.finances.notebook.domain.request.types.DetailsRequest;
import org.owner.finances.notebook.domain.request.types.UpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController
{
    @Autowired
    private UserService userService;

    @PostMapping("/user/details")
    public ResponseEntity<User> consultUserDetails(@Validated({DetailsRequest.class}) @RequestBody UserRequest userRequest)
    {
        return ResponseEntity.ok(userService.consultUser(userRequest));
    }

    @PostMapping("/user/signup")
    public ResponseEntity<User> createUser(@Validated({CreateRequest.class}) @RequestBody UserRequest userRequest)
    {
        return ResponseEntity.ok(userService.createUser(userRequest));
    }

    @PutMapping("/user/edit")
    public ResponseEntity<User> updateUser(@Validated({UpdateRequest.class}) @RequestBody UserRequest userRequest)
    {
        return ResponseEntity.ok(userService.updateUser(userRequest));
    }

    @DeleteMapping("/user/delete")
    public ResponseEntity<User> deleteUser(@Validated({DetailsRequest.class}) @RequestBody UserRequest userRequest)
    {
        return ResponseEntity.ok(userService.deleteUser(userRequest));
    }
}
