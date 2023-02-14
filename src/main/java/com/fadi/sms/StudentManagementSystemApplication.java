package com.fadi.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import com.fadi.sms.entity.Student;
import com.fadi.sms.repository.StudentRepository;
import com.fadi.sms.service.StudentService;*/

@SpringBootApplication
/*
 * from here run our Project
 */
public class StudentManagementSystemApplication /* implements CommandLineRunner */ {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	// Define a studentService object to add some defaults students data to DB when
	// our App run at the first time

	/*
	 * @Autowired
	 *private StudentRepository studentRepository;

	 * @Override public void run(String... args) throws Exception { /*
	 * studentRepository.save(new Student("Fadi", "Salameh", "fadi@gmail.com"));
	 * studentRepository.save(new Student("Noor", "Salim", "noor@gmail.com"));
	 * studentRepository.save(new Student("Eman", "Salameh", "eman@gmail.com"));
	 * 
	 * }
	 */

}
