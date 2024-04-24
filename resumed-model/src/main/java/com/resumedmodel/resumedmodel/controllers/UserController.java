package com.resumedmodel.resumedmodel.controllers;

import com.github.javafaker.Faker;
import com.resumedmodel.resumedmodel.models.DTO.UserDTO;
import com.resumedmodel.resumedmodel.models.Foo;
import com.resumedmodel.resumedmodel.models.FooBar;
import com.resumedmodel.resumedmodel.models.FooBarLong;
import com.resumedmodel.resumedmodel.models.UserModel;
import com.resumedmodel.resumedmodel.repositories.FooBarLongRepository;
import com.resumedmodel.resumedmodel.repositories.FooBarRepository;
import com.resumedmodel.resumedmodel.repositories.FooRepository;
import com.resumedmodel.resumedmodel.repositories.UserRepository;
import com.resumedmodel.resumedmodel.utils.ApiObjectMapper;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostConstruct
    private void onInit() {
        saveAllUsers();
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FooRepository fooRepository;

    @Autowired
    private FooBarRepository fooBarRepository;

    @Autowired
    private FooBarLongRepository fooBarLongRepository;

    @Autowired
    private ApiObjectMapper<UserDTO> apiObjectMapper;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAll() {
        return ResponseEntity.ok(userRepository.findAll().stream().map(
                user -> user.resume(apiObjectMapper)
        ).collect(Collectors.toList()));
    } //200OK 866 ms 2.7 MB

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
            var foo = new Foo(
                    faker.music().instrument(),
                    faker.zelda().game(),
                    faker.zelda().character(),
                    faker.zelda().game(),
                    faker.zelda().character());
            foos.add(fooRepository.save(foo));

        }
        return foos;
    }
    private List<FooBar> getFooBar() {
        List<FooBar> foos = new ArrayList<>();
        int i = 1;
        while (i < 50) {
            i++;
            var faker = new Faker();
            var fooBar = new FooBar(
                    faker.music().instrument(),
                    faker.zelda().game(),
                    faker.zelda().character(),
                    faker.zelda().game(),
                    faker.zelda().character(),
                    new HashSet<>(faker.lorem().words())

            );
            foos.add(fooBarRepository.save(fooBar));
        }
        return foos;
    }
    private List<FooBarLong> getFooBarLong() {
        List<FooBarLong> foos = new ArrayList<>();
        int i = 1;
        while (i < 50) {
            i++;
            var faker = new Faker();
            var foobarLong = new FooBarLong(
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

            );
            foos.add(fooBarLongRepository.save(foobarLong));
        }
        return foos;
    }
}
