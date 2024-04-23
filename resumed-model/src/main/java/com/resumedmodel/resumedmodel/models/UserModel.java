package com.resumedmodel.resumedmodel.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String description;
    @OneToMany
    private List<Foo> foo;
    @OneToMany
    private List<FooBar> fooBars;
    @OneToMany
    private List<FooBarLong> fooBarLongs;

    public UserModel(String name,
                     String email,
                     String description,
                     List<Foo> foo,
                     List<FooBar> fooBars,
                     List<FooBarLong> fooBarLongs) {
        this.name = name;
        this.email = email;
        this.description = description;
        this.foo = foo;
        this.fooBars = fooBars;
        this.fooBarLongs = fooBarLongs;
    }
}
