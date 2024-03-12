package com.studentmangement.Repository;

import com.studentmangement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

// Make sure to use the correct type for the primary key (e.g., Long)
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // You can add custom repository methods here
}
