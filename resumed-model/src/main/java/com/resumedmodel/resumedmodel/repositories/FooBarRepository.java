package com.resumedmodel.resumedmodel.repositories;

import com.resumedmodel.resumedmodel.models.FooBar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FooBarRepository extends JpaRepository<FooBar, Long> {
}
