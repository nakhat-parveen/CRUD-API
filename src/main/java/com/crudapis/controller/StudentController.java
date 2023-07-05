package com.crudapis.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudapis.entities.Student;
import com.crudapis.exceptions.NotFoundException;
import com.crudapis.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
@Validated
@CacheConfig(cacheNames="students")
public class StudentController {
	@Autowired
	StudentService studentservice;
	
	@PostMapping("/save")
	public Student createStudent(@Valid @RequestBody Student student) {
		return studentservice.addstudent(student);
	}
	
	 @GetMapping("/")
	    public ResponseEntity<List<Student>> getAllStudents() {
	        return ResponseEntity.ok(studentservice.getAllStudents()) ;
	    }
	
	@GetMapping("/{id}")
	@Cacheable(key="#id")
	public ResponseEntity<?> getStudentById(@PathVariable Integer id) throws NotFoundException {
		Student student =studentservice.getStudent(id);
        System.out.println("data coming from db");
		return new ResponseEntity<>(student,HttpStatus.OK);
	
	}
	
	 @PutMapping("/{id}")
	 @CachePut(key="#id")
	    public ResponseEntity<Student>  updateStudent(@PathVariable Integer id, @Valid @RequestBody Student updatedStudent) throws NotFoundException {
		 updatedStudent.setId(id);
		 return new ResponseEntity<Student> (studentservice.updateStudent(updatedStudent), HttpStatus.ACCEPTED);
	 }
	        
	
	 @DeleteMapping("/{id}")
	 @CacheEvict(key="#id")
	    public ResponseEntity<String> deleteStudent(@PathVariable Integer id) throws NotFoundException {
	
	        return new ResponseEntity<String>( studentservice.deleteStudent(id), HttpStatus.OK);
	    }

}
