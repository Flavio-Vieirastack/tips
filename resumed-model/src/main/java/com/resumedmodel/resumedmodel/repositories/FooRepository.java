package com.resumedmodel.resumedmodel.repositories;

import com.resumedmodel.resumedmodel.models.Foo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FooRepository extends JpaRepository<Foo, Long> {
}
