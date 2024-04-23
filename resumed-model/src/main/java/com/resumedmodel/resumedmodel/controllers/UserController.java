package com.resumedmodel.resumedmodel.controllers;

import com.github.javafaker.Faker;
import com.resumedmodel.resumedmodel.models.Foo;
import com.resumedmodel.resumedmodel.models.FooBar;
import com.resumedmodel.resumedmodel.models.FooBarLong;
import com.resumedmodel.resumedmodel.models.UserModel;
import com.resumedmodel.resumedmodel.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostConstruct
    private void onInit() {
        saveAllUsers();
    }

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<UserModel>> getAll() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<UserModel> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userRepository.findById(id).orElseThrow(
                RuntimeException::new
        ));
    }

    private void saveAllUsers() {
        int i = 1;
        while (i < 100) {
            i++;
            var faker = new Faker();
            var user = new UserModel(
                    faker.name().fullName(),
                    faker.internet().emailAddress(),
                    faker.lorem().characters(100),
                    getFoo(),
                    getFooBar(),
                    getFooBarLong()
            );
            userRepository.save(user);
        }
    }

    private List<Foo> getFoo() {
        List<Foo> foos = new ArrayList<>();
        int i = 1;
        while (i < 50) {
            i++;
            var faker = new Faker();
            foos.add(new Foo(
                    faker.music().instrument(),
                    faker.zelda().game(),
                    faker.zelda().character(),
                    faker.zelda().game(),
                    faker.zelda().character()

            ));
        }
        return foos;
    }
    private List<FooBar> getFooBar() {
        List<FooBar> foos = new ArrayList<>();
        int i = 1;
        while (i < 50) {
            i++;
            var faker = new Faker();
            foos.add(new FooBar(
                    faker.music().instrument(),
                    faker.zelda().game(),
                    faker.zelda().character(),
                    faker.zelda().game(),
                    faker.zelda().character(),
                    new HashSet<>(faker.lorem().words())

            ));
        }
        return foos;
    }
    private List<FooBarLong> getFooBarLong() {
        List<FooBarLong> foos = new ArrayList<>();
        int i = 1;
        while (i < 50) {
            i++;
            var faker = new Faker();
            foos.add(new FooBarLong(
                    faker.music().instrument(),
                    faker.zelda().game(),
                    faker.zelda().character(),
                    faker.zelda().game(),
                    faker.zelda().character(),
                    faker.artist().name(),
                    faker.artist().name(),
                    faker.artist().name(),
                    faker.artist().name(),
                    faker.artist().name(),
                    faker.artist().name(),
                    new HashSet<>(faker.lorem().words()),
                    new HashSet<>(faker.lorem().words())

            ));
        }
        return foos;
    }
}
