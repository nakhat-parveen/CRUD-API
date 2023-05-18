package com.crudapis.service;

import java.util.List;
import java.util.Optional;

import com.crudapis.entities.Student;

public interface StudentService {
	
	List<Student> getAllStudents();
	Student getStudent(Integer id);
	Student updateStudent(Student student);
	Student addstudent(Student student);
	String deleteStudent(Integer id);

}
