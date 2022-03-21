package com.example.sampleCBproject.controller;

import com.example.sampleCBproject.entity.Employee;
import com.example.sampleCBproject.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService UserService;

    @GetMapping("/")
    public List<Employee> getUsers() {
        return UserService.getUsers();
    }

    @PostMapping("/")
    public HttpStatus postUser(@RequestBody Employee e) {
        return UserService.postUser(e);
    }

    @GetMapping("/{id}")
    public Optional<Employee> getOneUser(@PathVariable String id) {
        return UserService.getOneUser(id);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteUser(@PathVariable String id) {
        return UserService.deleteUser(id);
    }

    @PutMapping("/")
    public  HttpStatus putUsers(@RequestBody Iterable<Employee> e) {
        return UserService.putUsers(e);
    }
}
