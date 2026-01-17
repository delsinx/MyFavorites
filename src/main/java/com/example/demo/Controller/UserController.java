package com.example.demo.Controller;


import com.example.demo.Model.UserModel;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")

public class UserController {


    @PostMapping("/register")
    public void registerUser(@Valid @RequestBody UserModel userModel) {}


    @GetMapping("/login")
    public void login(@Valid @RequestBody UserModel userModel) {}

    @DeleteMapping("/delete")

    @PutMapping("/update")
    public void updateUserInfo(@Valid @RequestBody UserModel userModel) {}



}
