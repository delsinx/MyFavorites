package com.example.demo.Controller;


import com.example.demo.Model.UserModel;
import com.example.demo.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")

public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public void registerUser(@Valid @RequestBody UserModel userModel) {}


    @GetMapping("/login")
    public void login(@Valid @RequestBody UserModel userModel) {}

    @DeleteMapping("/delete")

    @PutMapping("/update")
    public void updateUserInfo(@Valid @RequestBody UserModel userModel) {}



}
