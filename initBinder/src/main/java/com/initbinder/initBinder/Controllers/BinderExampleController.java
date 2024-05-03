package com.initbinder.initBinder.Controllers;

import com.initbinder.initBinder.Users;
import com.initbinder.initBinder.UserRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class BinderExampleController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public Users create(@RequestBody Users users) {
        return userRepository.save(users);
    }

    @GetMapping
    public List<Users> findAll() {
        return userRepository.findAll();
    }
}
