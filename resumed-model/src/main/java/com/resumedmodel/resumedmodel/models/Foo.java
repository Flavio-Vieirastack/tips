package com.resumedmodel.resumedmodel.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Foo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String foo1;
    private String foo2;
    private String foo3;
    private String foo4;
    private String foo5;

    public Foo(String foo1, String foo2, String foo3, String foo4, String foo5) {
        this.foo1 = foo1;
        this.foo2 = foo2;
        this.foo3 = foo3;
        this.foo4 = foo4;
        this.foo5 = foo5;
    }
}
