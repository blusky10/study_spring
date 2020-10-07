package com.polpid.common.user.web;

import com.polpid.common.user.domain.Users;
import com.polpid.common.user.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserRestController {

    private UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<Users> greeting() {
        return userService.findAll();
    }
}
