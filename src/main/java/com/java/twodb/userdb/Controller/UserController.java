package com.java.twodb.userdb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.twodb.userdb.Model.User;
import com.java.twodb.userdb.Repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/test")
    public String test(){
        return "This Port Works!";
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping("/all")
    public List<User> getUsers(){
        return userRepository.findAll();
    }
}
