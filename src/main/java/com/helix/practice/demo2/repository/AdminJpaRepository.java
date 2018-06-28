package com.helix.practice.demo2.repository;

import com.helix.practice.demo2.models.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface AdminJpaRepository extends JpaRepository<AdminUser, Long> {
    AdminUser findByUsername(String username);
}
