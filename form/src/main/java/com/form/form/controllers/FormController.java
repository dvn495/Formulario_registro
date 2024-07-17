package com.form.form.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.form.form.model.User;
import com.form.form.service.UserService;

@Controller
public class FormController {

    @Autowired
    private UserService userService;

    @GetMapping("/form")
    public String showForm() {
        return "form";
    }

    @PostMapping("/form")
    @ResponseBody
    public ResponseEntity<String> submitForm(@RequestBody User user) {
        try {
            userService.saveUser(user);
            return ResponseEntity.ok("User saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving user!");
        }
    }
}

