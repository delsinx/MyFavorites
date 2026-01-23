package com.example.demo.Controller;


import com.example.demo.DTO.UserDTO;
import com.example.demo.Model.UserModel;
import com.example.demo.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO) {
        UserDTO user = userService.registerUser(userDTO);
        if (user != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User registration failed");
        }
    }

    @GetMapping("/{id}")
    public UserDTO showUserByID(@PathVariable Long id) {
        return userService.showUserById(id);
    }

    @GetMapping("/allusers")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();

        if (users == null || users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.ok(users);
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserByID(@PathVariable Long id) {
        UserDTO deleteUser = userService.deleteUserById(id);
        if (deleteUser != null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("User deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

    @PutMapping("/update")
    public void updateUserInfo(@RequestBody UserModel userModel) {
    }


}
