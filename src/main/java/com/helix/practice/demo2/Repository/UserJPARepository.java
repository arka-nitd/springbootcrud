package com.helix.practice.demo2.Repository;

import com.helix.practice.demo2.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserJPARepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
}
