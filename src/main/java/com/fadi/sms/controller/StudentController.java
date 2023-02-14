package com.fadi.sms.controller;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.fadi.sms.entity.Student;
import com.fadi.sms.service.StudentService;

import java.util.List;

/*
 * define Student controller to handle all request from client side
 */

@Controller
public class StudentController {

	// define object from student service to do all operation in DB
	// we are using Dependency injection (automatic in Springboot)
	StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	// get all students in DB (without pagination)
	@GetMapping("/students")
	//@PreAuthorize("hasAuthority('ROLE_USER')")
	public String listStudents(Model model) {
		// define new Model to add all student data, then we can
		// use this Data in View layer (students.html)
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}

	// method to call student form, to make user insert new student
	@GetMapping("/students/new")
	//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String getStudentForm(Model model) {
		// create new Student to hold Form
		Student s = new Student();
		model.addAttribute("student", s);
		return "create_student";

	}
	
	// method to save student data in DB
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}

	// method to call edit student form
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.findStudentById(id));
		return "edit_student";
	}

	// method to update user data in DB
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable long id, @ModelAttribute("student") Student student, Model model) {
		// Get Employee from DB
		Student existStudent = studentService.findStudentById(id);
		// update students data
		existStudent.setFirstName(student.getFirstName());
		existStudent.setLastName(student.getLastName());
		existStudent.setEmail(student.getEmail());
		// update new data in DB
		studentService.updateStudent(existStudent);
		return "redirect:/students";
	}

	// method to delete student from DB
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}

}