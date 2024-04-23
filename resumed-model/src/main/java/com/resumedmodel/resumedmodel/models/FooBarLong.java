package com.resumedmodel.resumedmodel.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class FooBarLong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String foo1;
    private String foo2;
    private String foo3;
    private String foo4;
    private String foo5;
    private String foo6;
    private String foo7;
    private String foo8;
    private String foo9;
    private String foo10;
    private String foo11;
    private Set<String> foo;
    private Set<String> fooStrings;

    public FooBarLong(String foo1, String foo2, String foo3, String foo4, String foo5, String foo6, String foo7, String foo8, String foo9, String foo10, String foo11, Set<String> foo, Set<String> fooStrings) {
        this.foo1 = foo1;
        this.foo2 = foo2;
        this.foo3 = foo3;
        this.foo4 = foo4;
        this.foo5 = foo5;
        this.foo6 = foo6;
        this.foo7 = foo7;
        this.foo8 = foo8;
        this.foo9 = foo9;
        this.foo10 = foo10;
        this.foo11 = foo11;
        this.foo = foo;
        this.fooStrings = fooStrings;
    }
}
