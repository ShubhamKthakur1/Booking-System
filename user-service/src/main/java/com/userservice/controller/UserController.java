package com.userservice.controller;

import com.userservice.model.UserDetail;
import com.userservice.repo.UserRepository;
import com.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    UserRepository userRepository;

    //creating user
    @PostMapping("/")
    public UserDetail createUser(@RequestBody UserDetail user) throws Exception {

        return this.userService.createUser(user);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDetail userData) {
        UserDetail user = userRepository.findByUsername(userData.getUsername());
        if (user.getUsername().equals(userData.getUsername()) &&
                user.getPassword().equals(userData.getPassword())) {
            return ResponseEntity.ok(user);
        }
        return (ResponseEntity<?>) ResponseEntity.internalServerError();

    }

    @GetMapping("/{username}")
    public UserDetail getUser(@PathVariable String username) {
        return this.userService.getUser(username);
    }

    @DeleteMapping("/{userId}")
    public void deleteUserById(@PathVariable Long userId) {
        this.userService.deleteUserById(userId);
    }


}


