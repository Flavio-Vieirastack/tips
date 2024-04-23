package com.resumedmodel.resumedmodel.repositories;

import com.resumedmodel.resumedmodel.models.FooBarLong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FooBarLongRepository extends JpaRepository<FooBarLong, Long> {
}
