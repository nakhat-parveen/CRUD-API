package com.crudapis.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudapis.entities.Student;
@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
