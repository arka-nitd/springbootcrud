package com.helix.practice.demo2.repository;

import com.helix.practice.demo2.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface StudentJpaRepository extends JpaRepository<Student, Long> {
}
