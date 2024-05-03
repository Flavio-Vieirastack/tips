package com.initbinder.initBinder.UserRepository;

import com.initbinder.initBinder.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
