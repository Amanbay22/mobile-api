package com.example.mobileapi.repositories;

import com.example.mobileapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String email);
}
