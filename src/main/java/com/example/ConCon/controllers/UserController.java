package com.example.ConCon.controllers;

import com.example.ConCon.model.User;
import com.example.ConCon.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@Controller
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

   

    @PostMapping("/createU")
    public String create(@Valid @RequestBody User user, BindingResult bindingResult) throws ExecutionException, InterruptedException {
        if (bindingResult.hasErrors()) {
            System.out.println("error");
            return "Error";
        } else {
            System.out.println();
            System.out.println(user);
            return userService.createUser(user);
        }
    }

    @DeleteMapping("/deleteU")
    public String deleteUser(@RequestBody String username) throws ExecutionException, InterruptedException {
        return userService.deleteUser(username);
    }

    @PutMapping("/alterarU")
    public String updateUser(@RequestBody User user) throws ExecutionException, InterruptedException {
        return userService.updateUser(user);
    }
}
