package com.sam.cookingapp.security.repositories;

import com.sam.cookingapp.security.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
