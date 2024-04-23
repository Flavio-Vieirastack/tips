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
public class FooBar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String foo1;
    private String foo2;
    private String foo3;
    private String foo4;
    private String foo5;
    private Set<String> foo;

    public FooBar(String foo1, String foo2, String foo3, String foo4, String foo5, Set<String> foo) {
        this.foo1 = foo1;
        this.foo2 = foo2;
        this.foo3 = foo3;
        this.foo4 = foo4;
        this.foo5 = foo5;
        this.foo = foo;
    }
}
