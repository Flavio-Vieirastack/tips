package com.resumedmodel.resumedmodel.repositories;

import com.resumedmodel.resumedmodel.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
}
