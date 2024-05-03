package com.initbinder.initBinder.Controllers;

import com.initbinder.initBinder.User;
import com.initbinder.initBinder.UserRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class BinderExampleController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }
}
