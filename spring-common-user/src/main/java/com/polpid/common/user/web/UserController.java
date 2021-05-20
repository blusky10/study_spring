package com.polpid.common.user.web;

import com.polpid.common.user.domain.Users;
import com.polpid.common.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<Users>> findUsers() {

        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/users/{email}")
    public ResponseEntity findUser(@PathVariable String email) {

        if (email == null){
            return ResponseEntity.badRequest().body("Email is Required");
        }else{
            try {
                Users userById = userService.findUserById(email);
                return ResponseEntity.ok(userById);
            }catch (RuntimeException e){
                return ResponseEntity.badRequest().body(e.getMessage());
            }

        }
    }

}
