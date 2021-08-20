package com.springboot.StudentDemo.Repository;

import com.springboot.StudentDemo.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID>{


}
