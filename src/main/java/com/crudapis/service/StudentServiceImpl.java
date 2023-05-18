package com.crudapis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudapis.dao.StudentRepo;
import com.crudapis.entities.Student;
import com.crudapis.exceptions.NotFoundException;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepo studentrepo;

	@Override
	public List<Student> getAllStudents() {

		return studentrepo.findAll();
	}

	@Override
	public Student getStudent(Integer id) {
		Optional<Student> student = Optional
				.ofNullable(studentrepo.findById(id).orElseThrow(() -> new NotFoundException("id not found")));
		return student.get();
//		if(student.isPresent())
//			return student.get();
//		else
//			throw new NotFoundException("id not found");
//		
	}

	@Override
	public Student updateStudent(Student student) {

		Student updatedstudent = studentrepo.findById(student.getId())
				.orElseThrow(() -> new NotFoundException("please insert the correct id"));
		updatedstudent.setAge(student.getAge());
		updatedstudent.setAddress(student.getAddress());
		updatedstudent.setName(student.getName());
		return updatedstudent;
	}

	@Override
	public String deleteStudent(Integer id) {

		studentrepo.findById(id).orElseThrow(() -> new NotFoundException("inserted id is not present"));
		studentrepo.deleteById(id);
		return "student deleted successfully";

	}

	@Override
	public Student addstudent(Student student) {

		return studentrepo.save(student);
	}

}
