package com.fadi.sms.service;

import java.util.List;

import com.fadi.sms.entity.Student;
import org.springframework.data.domain.Page;

/*
 * interface to define all operation, which we use on Student table
 */
public interface StudentService {

	public List<Student> getAllStudents();
	public Student saveStudent(Student student);
	public Student findStudentById(long id);
	public Student updateStudent(Student student);
	public void deleteStudentById(long id);

}
